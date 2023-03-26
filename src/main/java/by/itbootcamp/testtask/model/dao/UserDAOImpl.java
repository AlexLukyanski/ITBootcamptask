package by.itbootcamp.testtask.model.dao;

import by.itbootcamp.testtask.bean.User;
import by.itbootcamp.testtask.bean.UserParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    private final static String HQL_READ_ALL_USERS = "from User";
    @Override
    public List<User> readAllUsers(int page, int size) {

        Session session = sessionFactory.getCurrentSession();
        long idCount = countUser();
        final int firstPageNumber = 1;
        int pagesAmount = (int) (idCount / size) + 1;

        Query<User> query = session.createQuery(HQL_READ_ALL_USERS, User.class);

        if (page == firstPageNumber) {
            query.setFirstResult(firstPageNumber - 1);
            query.setMaxResults(size);
        } else if (page > firstPageNumber && page <= pagesAmount) {
            query.setFirstResult((page - 1) * size);
            query.setMaxResults(page * size);
        }
        return query.getResultList();
    }

    private final static String HQL_READ_ALL_ROLES = "select E.name from Role E";
    @Override
    public List<String> readAllRoles() {

        Session session = sessionFactory.getCurrentSession();
        Query<String> query = session.createQuery(HQL_READ_ALL_ROLES, String.class);

        return query.getResultList();
    }

    private final static String HQL_CHECK_EXIST = "select id from User where email=:userEmail";
    @Override
    public boolean isEmailNotExist(String email) {

        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery(HQL_CHECK_EXIST, Integer.class);
        query.setParameter(UserParam.USER_EMAIL, email);

        if (query.uniqueResult() != null) {
            return false;
        }
        return true;
    }

    private final static String HQL_COUNT_USER_ID = "Select count (E.id) from User E";
    @Override
    public long countUser() {

        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery(HQL_COUNT_USER_ID, Long.class);

        return query.uniqueResult();
    }
}

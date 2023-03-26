package by.itbootcamp.testtask.model.service;

import by.itbootcamp.testtask.bean.User;
import by.itbootcamp.testtask.model.dao.UserDAO;
import by.itbootcamp.testtask.model.service.validation.PageValidation;
import by.itbootcamp.testtask.model.service.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void addUser(User user) {

        UserValidation validation = validate(user);

        if (validation.isUserValid()) {
            userDAO.addUser(user);

        } else {
            throw new ServiceValidationException("User not valid");
        }
    }

    @Transactional
    @Override
    public List<UserResponse> readAllUsersSortedByEmail(int page, int size) {

        PageValidation validation = validate(page, size);

        if (validation.isPageValid()) {

            List<User> users = userDAO.readAllUsers(page, size);
            List<UserResponse> responseUsers = createUserResponseList(users);
            responseUsers.sort((first, second) -> first.getEmail().compareTo(second.getEmail()));

            return responseUsers;
        } else {
            throw new PageNotFoundException("Such page does not exist");
        }
    }

    private UserValidation validate(User user) {

        List<String> rolesList = userDAO.readAllRoles();
        boolean emailAlreadyExist = userDAO.isEmailNotExist(user.getEmail());

        return new UserValidation.UserValidationBuilder()
                .isSurnameValid(user.getSurname())
                .isNameValid(user.getName())
                .isPatronymicValid(user.getPatronymic())
                .isEmailAlreadyExist(emailAlreadyExist)
                .isEmailValid(user.getEmail())
                .isRoleValid(user.getRole().getName(), rolesList)
                .build();
    }

    private PageValidation validate(int page, int size) {

        long userCount = userDAO.countUser();

        return new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build();
    }

    private List<UserResponse> createUserResponseList(List<User> users) {

        List<UserResponse> responseUsers = new ArrayList<>();

        for (User user : users) {
            responseUsers.add(new UserResponse(user));
        }
        return responseUsers;
    }

}

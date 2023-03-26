package by.itbootcamp.testtask.model.dao;

import by.itbootcamp.testtask.bean.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> readAllUsers(int page, int size);

    List<String> readAllRoles();

    boolean isEmailNotExist(String email);

    long countUser();
}

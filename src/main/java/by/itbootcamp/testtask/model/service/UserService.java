package by.itbootcamp.testtask.model.service;

import by.itbootcamp.testtask.bean.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<UserResponse> readAllUsersSortedByEmail(int page, int size);
}

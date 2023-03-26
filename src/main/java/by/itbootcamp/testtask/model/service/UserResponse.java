package by.itbootcamp.testtask.model.service;

import by.itbootcamp.testtask.bean.User;

import java.io.Serializable;


public class UserResponse implements Serializable {

    private final String fullName;
    private final String email;
    private final String role;

    private static final long serialVersionUID = 5743724643743523472L;

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public UserResponse(User user) {
        this.fullName = createFullName(user);
        this.email = user.getEmail();
        this.role = user.getRole().getName();
    }

    private String createFullName(User user) {

        StringBuilder fullName = new StringBuilder()
                .append(user.getSurname())
                .append(" ")
                .append(user.getName());

        if (!user.getPatronymic().isBlank()) {
            fullName.append(" ")
                    .append(user.getPatronymic());
        }
        return fullName.toString();
    }

}

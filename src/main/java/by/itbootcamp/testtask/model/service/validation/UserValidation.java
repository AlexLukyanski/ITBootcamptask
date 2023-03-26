package by.itbootcamp.testtask.model.service.validation;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    private final boolean surnameValid;
    private final boolean nameValid;
    private final boolean patronymicValid;
    private final boolean emailValid;
    private final boolean emailAlreadyExist;
    private final boolean roleValid;

    public UserValidation(UserValidationBuilder builder) {

        this.surnameValid = builder.surnameValid;
        this.nameValid = builder.nameValid;
        this.patronymicValid = builder.patronymicValid;
        this.emailValid = builder.emailValid;
        this.emailAlreadyExist = builder.emailAlreadyExist;
        this.roleValid = builder.roleValid;
    }

    public boolean isSurnameValid() {
        return surnameValid;
    }

    public boolean isNameValid() {
        return nameValid;
    }

    public boolean isPatronymicValid() {
        return patronymicValid;
    }

    public boolean isEmailValid() {
        return emailValid;
    }

    public boolean isEmailAlreadyExist() {
        return emailAlreadyExist;
    }

    public boolean isRoleValid() {
        return roleValid;
    }

    public boolean isUserValid() {
        return surnameValid && nameValid && patronymicValid && emailValid && roleValid && emailAlreadyExist;
    }

    public static class UserValidationBuilder {

        private boolean surnameValid;
        private boolean nameValid;
        private boolean patronymicValid;
        private boolean emailValid;
        private boolean emailAlreadyExist;
        private boolean roleValid;

        public UserValidationBuilder isSurnameValid(String surname) {

            if (surname == null) {
                surnameValid = false;
                return this;
            }

            String regex = "^[a-zA-Z]{1,40}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(surname);
            surnameValid = matcher.matches();

            return this;
        }

        public UserValidationBuilder isNameValid(String name) {

            if (name == null) {
                nameValid = false;
                return this;
            }

            String regex = "^[a-zA-Z]{1,20}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);
            nameValid = matcher.matches();

            return this;
        }

        public UserValidationBuilder isPatronymicValid(String patronymic) {

            String regex = "^[a-zA-Z]{0,40}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(patronymic);
            patronymicValid = matcher.matches();

            return this;
        }

        public UserValidationBuilder isEmailValid(String email) {

            if (email == null) {
                emailValid = false;
                return this;
            }

            final int maxEmailLength = 50;

            if (email.length() > maxEmailLength) {
                emailValid = false;
                return this;
            }

            String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            emailValid = matcher.matches();

            return this;
        }

        public UserValidationBuilder isEmailAlreadyExist(boolean emailAlreadyExist) {

            this.emailAlreadyExist = emailAlreadyExist;
            return this;
        }

        public UserValidationBuilder isRoleValid(String role, List<String> rolesList) {

            if (role == null || rolesList == null || rolesList.size() < 1) {
                roleValid = false;
                return this;
            }

            for (String roleName : rolesList) {
                if (roleName.equals(role)) {
                    roleValid = true;
                    return this;
                }
            }
            roleValid = false;
            return this;
        }

        public UserValidation build() {
            return new UserValidation(this);
        }
    }
}

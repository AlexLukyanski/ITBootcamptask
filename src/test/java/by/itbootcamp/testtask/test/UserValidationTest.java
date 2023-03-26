package by.itbootcamp.testtask.test;

import by.itbootcamp.testtask.model.service.validation.UserValidation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidationTest {

    @Nested
    public class isSurnameValidTest {

        @Test
        public void should_ReturnFalse_When_Surname_isNull() {

            //given
            String surname = null;

            //when
            boolean isSurnameValid = new UserValidation.UserValidationBuilder()
                    .isSurnameValid(surname)
                    .build()
                    .isSurnameValid();

            //then
            assertFalse(isSurnameValid);
        }

        @Test
        public void should_ReturnFalse_When_Surname_Contains_WrongLetters() {

            //given
            String surname = "@%/gaerhrea";

            //when
            boolean isSurnameValid = new UserValidation.UserValidationBuilder()
                    .isSurnameValid(surname)
                    .build()
                    .isSurnameValid();

            //then
            assertFalse(isSurnameValid);
        }

        @Test
        public void should_ReturnFalse_When_Surname_BiggerLength_Than_Allowed() {

            //given
            String surname = "abcdefghijabcdefghijabcdefghijabcdefghija";

            //when
            boolean isSurnameValid = new UserValidation.UserValidationBuilder()
                    .isSurnameValid(surname)
                    .build()
                    .isSurnameValid();

            //then
            assertFalse(isSurnameValid);
        }

        @Test
        public void should_ReturnTrue_When_Surname_Equal_AllowedLength() {

            //given
            String surname = "abcdefghijabcdefghijabcdefghijabcdefghij";

            //when
            boolean isSurnameValid = new UserValidation.UserValidationBuilder()
                    .isSurnameValid(surname)
                    .build()
                    .isSurnameValid();

            //then
            assertTrue(isSurnameValid);
        }

        @Test
        public void should_ReturnTrue_When_Surname_LesserLength_Than_Allowed() {

            //given
            String surname = "sdgh";

            //when
            boolean isSurnameValid = new UserValidation.UserValidationBuilder()
                    .isSurnameValid(surname)
                    .build()
                    .isSurnameValid();

            //then
            assertTrue(isSurnameValid);
        }
    }

    @Nested
    public class isNameValidTest {

        @Test
        public void should_ReturnFalse_When_Name_isNull() {

            //given
            String name = null;

            //when
            boolean isNameValid = new UserValidation.UserValidationBuilder()
                    .isNameValid(name)
                    .build()
                    .isNameValid();

            //then
            assertFalse(isNameValid);
        }

        @Test
        public void should_ReturnFalse_When_Name_Contains_WrongLetters() {

            //given
            String name = "@%/gaerhrea";

            //when
            boolean isNameValid = new UserValidation.UserValidationBuilder()
                    .isNameValid(name)
                    .build()
                    .isNameValid();

            //then
            assertFalse(isNameValid);
        }

        @Test
        public void should_ReturnFalse_When_Name_BiggerLength_Than_Allowed() {

            //given
            String name = "abcdefghijabcdefghijf";

            //when
            boolean isNameValid = new UserValidation.UserValidationBuilder()
                    .isNameValid(name)
                    .build()
                    .isNameValid();

            //then
            assertFalse(isNameValid);
        }

        @Test
        public void should_ReturnTrue_When_Name_Equal_AllowedLength() {

            //given
            String name = "abcdefghijabcdefghij";

            //when
            boolean isNameValid = new UserValidation.UserValidationBuilder()
                    .isNameValid(name)
                    .build()
                    .isNameValid();

            //then
            assertTrue(isNameValid);
        }

        @Test
        public void should_ReturnTrue_When_Name_LesserLength_Than_Allowed() {

            //given
            String name = "abcdefghijabcdefghi";

            //when
            boolean isNameValid = new UserValidation.UserValidationBuilder()
                    .isNameValid(name)
                    .build()
                    .isNameValid();

            //then
            assertTrue(isNameValid);
        }
    }

    @Nested
    public class isPatronymicVaild {

        @Test
        public void should_ReturnFalse_When_Patronymic_Contains_WrongLetters() {

            //given
            String patronymic = "@%/gaerhrea";

            //when
            boolean isPatronymicValid = new UserValidation.UserValidationBuilder()
                    .isPatronymicValid(patronymic)
                    .build()
                    .isPatronymicValid();

            //then
            assertFalse(isPatronymicValid);
        }

        @Test
        public void should_ReturnFalse_When_Patronymic_BiggerLength_Than_Allowed() {

            //given
            String patronymic = "abcdefghijabcdefghijabcdefghijabcdefghija";

            //when
            boolean isPatronymicValid = new UserValidation.UserValidationBuilder()
                    .isPatronymicValid(patronymic)
                    .build()
                    .isPatronymicValid();

            //then
            assertFalse(isPatronymicValid);
        }

        @Test
        public void should_ReturnTrue_When_Patronymic_Equal_AllowedLength() {

            //given
            String patronymic = "abcdefghijabcdefghijabcdefghijabcdefghij";

            //when
            boolean isPatronymicValid = new UserValidation.UserValidationBuilder()
                    .isPatronymicValid(patronymic)
                    .build()
                    .isPatronymicValid();

            //then
            assertTrue(isPatronymicValid);
        }

        @Test
        public void should_ReturnTrue_When_Patronymic_LesserLength_Than_Allowed() {

            //given
            String patronymic = "abcdefghijabcdefghijabcdefghijabcdefghi";

            //when
            boolean isPatronymicValid = new UserValidation.UserValidationBuilder()
                    .isPatronymicValid(patronymic)
                    .build()
                    .isPatronymicValid();

            //then
            assertTrue(isPatronymicValid);
        }
    }

    @Nested
    public class isEmailValid {

        @Test
        public void should_ReturnFalse_When_Email_isNull() {

            //given
            String email = null;

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailValid(email)
                    .build()
                    .isEmailValid();

            //then
            assertFalse(isEmailValid);
        }

        @Test
        public void should_ReturnFalse_When_Email_BiggerLength_Than_Allowed() {

            //given
            String email = "abcdefghijabcdefghija@cdefghijabcdefghijabcdefgh.jq";

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailValid(email)
                    .build()
                    .isEmailValid();

            //then
            assertFalse(isEmailValid);
        }

        @Test
        public void should_ReturnTrue_When_Email_Equal_AllowedLength() {

            //given
            String email = "abcdefghijabcdefghija@cdefghijabcdefghijabcdefg.ij";

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailValid(email)
                    .build()
                    .isEmailValid();

            //then
            assertTrue(isEmailValid);
        }

        @Test
        public void should_ReturnTrue_When_Email_LesserLength_Than_Allowed() {

            //given
            String email = "abcdefghijabcdefghija@cdefghijabcdefghijabcdef.hi";

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailValid(email)
                    .build()
                    .isEmailValid();

            //then
            assertTrue(isEmailValid);
        }

        @Test
        public void should_ReturnFalse_When_Email_DoNot_Have_Specific_Letters() {

            //given
            String email = "abcdefghijabcdefghijacdefghijabcdefghijabcdefgh.jq";

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailValid(email)
                    .build()
                    .isEmailValid();

            //then
            assertFalse(isEmailValid);
        }

        @Test
        public void should_ReturnTrue_When_Email_Exist() {

            //given
            boolean emailAlreadyExist = true;

            //when
            boolean isEmailValid = new UserValidation.UserValidationBuilder()
                    .isEmailAlreadyExist(emailAlreadyExist)
                    .build()
                    .isEmailAlreadyExist();

            //then
            assertTrue(isEmailValid);
        }
    }

    @Nested
    public class isRoleValid {

        @Test
        public void should_ReturnFalse_When_Role_isNull() {

            //given
            String role = null;
            List<String> roles = new ArrayList<>();

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertFalse(isRoleValid);
        }

        @Test
        public void should_ReturnFalse_When_RolesList_isNull() {

            //given
            String role = "Administrator";
            List<String> roles = null;

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertFalse(isRoleValid);
        }

        @Test
        public void should_ReturnFalse_When_RolesListAndRole_isNull() {

            //given
            String role = null;
            List<String> roles = null;

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertFalse(isRoleValid);
        }

        @Test
        public void should_ReturnFalse_When_RolesList_isEmpty() {

            //given
            String role = "Administrator";
            List<String> roles = new ArrayList<>();

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertFalse(isRoleValid);
        }

        @Test
        public void should_ReturnTrue_When_RolesList_ContainRole() {

            //given
            String role = "Administrator";
            List<String> roles = new ArrayList<>();
            roles.add(role);

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertTrue(isRoleValid);
        }

        @Test
        public void should_ReturnFalse_When_RolesList_DoesNot_ContainRole() {

            //given
            String role = "None";
            List<String> roles = new ArrayList<>();
            roles.add("Administrator");

            //when
            boolean isRoleValid = new UserValidation.UserValidationBuilder()
                    .isRoleValid(role, roles)
                    .build()
                    .isRoleValid();

            //then
            assertFalse(isRoleValid);
        }
    }
}

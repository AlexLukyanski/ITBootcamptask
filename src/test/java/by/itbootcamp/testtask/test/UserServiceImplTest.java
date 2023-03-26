package by.itbootcamp.testtask.test;

import by.itbootcamp.testtask.bean.Role;
import by.itbootcamp.testtask.bean.User;
import by.itbootcamp.testtask.model.dao.UserDAOImpl;
import by.itbootcamp.testtask.model.service.PageNotFoundException;
import by.itbootcamp.testtask.model.service.ServiceValidationException;
import by.itbootcamp.testtask.model.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    private UserServiceImpl userService;
    private UserDAOImpl userDAO;

    @Nested
    public class AddUserTest {

        private User user;
        private Role role;
        private List<String> roles;

        @BeforeEach
        void setUpUserTest() {
            UserServiceImplTest.this.userDAO = mock(UserDAOImpl.class);
            UserServiceImplTest.this.userService = new UserServiceImpl(userDAO);

            this.role = new Role();
            role.setId(1);
            role.setName("Administrator");

            this.user = new User();
            user.setSurname("zdafhrsth");
            user.setName("DSghrgg");
            user.setPatronymic("dafah");
            user.setRole(role);
            user.setEmail("dzfbdhb@ffff.hh");

            this.roles = new ArrayList<>();
            roles.add("Administrator");
        }

        @Test
        public void should_InvokeMethod_addUser_When_UserValid() {

            //given
            when(userDAO.readAllRoles()).thenReturn(roles);
            when(userDAO.isEmailNotExist(user.getEmail())).thenReturn(true);

            //when
            userService.addUser(user);

            //then
            verify(userDAO).addUser(user);
        }

        @Test
        public void should_Throw_ServiceValidationException_When_UserNotValid() {
            //given
            when(userDAO.readAllRoles()).thenReturn(roles);
            when(userDAO.isEmailNotExist(user.getEmail())).thenReturn(false);

            //when
            Executable executable = () -> userService.addUser(user);

            //then
            assertThrows(ServiceValidationException.class, executable);
        }
    }

    @Nested
    public class ReadAllUsersSortedByEmailTest {

        @BeforeEach
        void setUpUserTest() {
            UserServiceImplTest.this.userDAO = mock(UserDAOImpl.class);
            UserServiceImplTest.this.userService = new UserServiceImpl(userDAO);
        }

        @Test
        public void should_InvokeMethod_readAllUsersSortedByEmail_When_PageValid() {

            //given
            int page = 0;
            int size = 10;
            when(userDAO.countUser()).thenReturn(15L);

            //when
            userService.readAllUsersSortedByEmail(page, size);

            //then
            verify(userDAO).readAllUsers(page, size);
        }

        @Test
        public void should_Throw_PageNotFoundException_When_PageNotValid() {
            //given
            int page = 5;
            int size = 10;
            when(userDAO.countUser()).thenReturn(15L);

            //when
            Executable executable = () -> userService.readAllUsersSortedByEmail(page, size);

            //then
            assertThrows(PageNotFoundException.class, executable);
        }
    }
}
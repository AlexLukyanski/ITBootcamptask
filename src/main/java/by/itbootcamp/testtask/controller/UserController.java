package by.itbootcamp.testtask.controller;

import by.itbootcamp.testtask.bean.User;
import by.itbootcamp.testtask.model.service.UserResponse;
import by.itbootcamp.testtask.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {

        userService.addUser(user);
        return ResponseEntity.ok("User successfully added");
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size) {


        return userService.readAllUsersSortedByEmail(page, size);
    }
}

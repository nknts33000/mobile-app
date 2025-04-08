package com.example.demo.user;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

//    @PostMapping("/register")
//    public ResponseEntity<UserDTO> register(@RequestBody UserDTO requestBody){
//        UserDTO userDTO= userService.register(requestBody);
//        return new ResponseEntity<>(userDTO,HttpStatus.CREATED);
//    }
}

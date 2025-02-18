package com.example.demo.user;

import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User(1, "test")
        );
    }
}

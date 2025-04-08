package com.example.demo.user;

import com.example.demo.entities.User;
import com.example.demo.mapper.CustomMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //private final CustomMapper customMapper;
    private final UserRepo userRepo;

//    public UserService(CustomMapper customMapper, UserRepo userRepo) {
//        //this.customMapper = customMapper;
//        this.userRepo = userRepo;
//    }

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers() {
        return List.of(
                new User(1, "test")
        );
    }

//    public UserDTO register(UserDTO userDTO) {
//        User user=customMapper.INSTANCE.toUser(userDTO);
//        return customMapper.INSTANCE.toDto(userRepo.save(user));
//    }
}

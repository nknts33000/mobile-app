package com.example.demo.user;

import com.example.demo.entities.User;
import com.example.demo.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public List<User> getUsers() {
//        return List.of(
//                new User(1, "test")
//        );
//    }

    public UserDTO register(UserDTO userDTO) {
        User user= CustomMapper.INSTANCE.toUser(userDTO);
        System.out.println("username"+user);
        User savedUser= userRepo.save(user);
        return CustomMapper.INSTANCE.toDto(savedUser);
    }
}

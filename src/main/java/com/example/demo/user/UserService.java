package com.example.demo.user;

import com.example.demo.Utils.Role;
import com.example.demo.entities.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final CustomMapper customMapper;

    @Autowired
    public UserService(UserRepo userRepo,CustomMapper customMapper) {
        this.userRepo = userRepo;
        this.customMapper=customMapper;
    }

    public List<UserDTO> getUsers() {
        List<User> users=userRepo.findAll();
        return users.stream()
                .map(customMapper::toDto)
                .toList();
    }

    public UserDTO register(RegistrationAndUpdateDTO registrationDTO) {
        User user= customMapper.toUserFromRegDto(registrationDTO);
        user.setRole(Role.CUSTOMER);
        User savedUser= userRepo.save(user);
        return customMapper.toDto(savedUser);
    }

    public UserDTO updateUser(RegistrationAndUpdateDTO dto){
        User user= userRepo.findById(dto.getUserId()).orElseThrow(()->new UserNotFoundException("User with id "+dto.getUserId()+" was not found"));
        if (dto.getUsername() != null && !dto.getUsername().isEmpty()) user.setUsername(dto.getUsername());
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) user.setPassword(dto.getPassword());
        if (dto.getName() != null && !dto.getName().isEmpty()) user.setName(dto.getName());
        if (dto.getSurname() != null && !dto.getSurname().isEmpty()) user.setSurname(dto.getSurname());
        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) user.setEmail(dto.getEmail());
        if (dto.getDateOfBirth() != null) user.setDateOfBirth(dto.getDateOfBirth());
        User savedUser=userRepo.save(user);
        return customMapper.toDto(savedUser);
    }

    public UserDTO findUser(long id) {
        User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" was not found"));
        return customMapper.toDto(user);
    }

    public void deleteUser(long id) {
        User user=userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" was not found"));
        userRepo.delete(user);
    }
}


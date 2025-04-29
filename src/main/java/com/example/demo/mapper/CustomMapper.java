package com.example.demo.mapper;

import com.example.demo.entities.User;
import com.example.demo.user.RegistrationAndUpdateDTO;
import com.example.demo.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomMapper {
    UserDTO toDto(User user);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "services", ignore = true)
    @Mapping(target = "sentMessages", ignore = true)
    @Mapping(target = "receivedMessages", ignore = true)
    @Mapping(target = "chats", ignore = true)
    @Mapping(target = "active", ignore = true)
    User toUserFromUserDto(UserDTO userDTO);

    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "projects", ignore = true)
    @Mapping(target = "services", ignore = true)
    @Mapping(target = "sentMessages", ignore = true)
    @Mapping(target = "receivedMessages", ignore = true)
    @Mapping(target = "chats", ignore = true)
    @Mapping(target = "active", ignore = true)
    User toUserFromRegDto(RegistrationAndUpdateDTO registrationDTO);
}

package com.example.demo.mapper;

import com.example.demo.entities.User;
import com.example.demo.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomMapper {
    CustomMapper INSTANCE = Mappers.getMapper(CustomMapper.class);

    UserDTO toDto(User user);

    User toUser(UserDTO userDTO);
}

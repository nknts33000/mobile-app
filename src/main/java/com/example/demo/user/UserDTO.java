package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private long userId;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String role;
}

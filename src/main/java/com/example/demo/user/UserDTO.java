package com.example.demo.user;

import com.example.demo.Utils.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.validation.Valid;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

    private long userId;

    @NotNull
    private String username;
    private String password;
    private String name;
    private String surname;
    @Email
    @NotNull
    private String email;
    @Valid
    @NotNull
    private Role role;
    private Date dateOfBirth;
}

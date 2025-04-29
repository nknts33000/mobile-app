package com.example.demo.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class RegistrationAndUpdateDTO extends UserDTO{
    @NotBlank
    private String password;
    @NotNull
    private Date dateOfBirth;
}

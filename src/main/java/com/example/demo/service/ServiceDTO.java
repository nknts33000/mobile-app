package com.example.demo.service;

import com.example.demo.user.UserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceDTO {
    private long serviceId;
    @NotBlank
    private String description;
    @NotBlank
    private String category;

    private Long userId;
}

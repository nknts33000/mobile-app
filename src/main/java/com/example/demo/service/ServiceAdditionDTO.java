package com.example.demo.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ServiceAdditionDTO {
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotNull
    private long userId;
}

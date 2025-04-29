package com.example.demo.exception;

public class BuildingServiceNotFoundException extends RuntimeException{
    public BuildingServiceNotFoundException(String message) {
        super(message);
    }
}

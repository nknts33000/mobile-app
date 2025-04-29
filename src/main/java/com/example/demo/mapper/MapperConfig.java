package com.example.demo.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mapstruct.factory.Mappers;

@Configuration
public class MapperConfig {
    @Bean
    public ServiceMapper serviceMapper() {
        return Mappers.getMapper(ServiceMapper.class);
    }

    @Bean
    public CustomMapper userMapper(){
        return Mappers.getMapper(CustomMapper.class);
    }
}

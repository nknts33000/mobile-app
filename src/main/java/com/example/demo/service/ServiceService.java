package com.example.demo.service;

import com.example.demo.entities.BuildingService;
import com.example.demo.entities.User;
import com.example.demo.exception.BuildingServiceNotFoundException;
import com.example.demo.mapper.CustomMapper;
import com.example.demo.mapper.ServiceMapper;
import com.example.demo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;

@Service
public class ServiceService {
    public final ServiceRepo serviceRepo;
    public final ServiceMapper serviceMapper;
    public final UserService userService;
    private final CustomMapper customMapper;

    @Autowired
    public ServiceService(ServiceRepo serviceRepo, ServiceMapper serviceMapper, UserService userService, CustomMapper customMapper){
        this.serviceRepo=serviceRepo;
        this.serviceMapper=serviceMapper;
        this.userService = userService;
        this.customMapper = customMapper;
    }

    public ServiceDTO addService(ServiceAdditionDTO serviceDTO){
        User user= customMapper.toUserFromUserDto(userService.findUser(serviceDTO.getUserId()));
        BuildingService service= serviceMapper.toServiceFromAdditionDTO(serviceDTO);
        service.setTechnician(user);
        BuildingService savedService=serviceRepo.save(service);
        return serviceMapper.toDto(savedService);
    }

    public ServiceDTO updateService(ServiceDTO serviceDTO){
        BuildingService service= serviceRepo.findById(serviceDTO.getServiceId())
                .orElseThrow(()->new BuildingServiceNotFoundException("Service with id "+serviceDTO.getServiceId()+" cannot be found."));
        if(serviceDTO.getCategory()!=null && !serviceDTO.getCategory().isEmpty()) service.setCategory(serviceDTO.getCategory());
        if(serviceDTO.getDescription()!=null && !serviceDTO.getDescription().isEmpty()) service.setDescription(serviceDTO.getDescription());
        if(serviceDTO.getUserId()!=null) service.setTechnician(customMapper.toUserFromUserDto(userService.findUser(serviceDTO.getUserId())));
        BuildingService updatedService=serviceRepo.save(service);
        return serviceMapper.toDto(updatedService);
    }

    public ServiceDTO findService(long id){
        BuildingService service=serviceRepo.findById(id)
                .orElseThrow(()->new BuildingServiceNotFoundException("Service with id "+id+" cannot be found."));
        return serviceMapper.toDto(service);
    }

    public void deleteService(long id){
        BuildingService service=serviceRepo.findById(id)
                .orElseThrow(()->new BuildingServiceNotFoundException("Service with id "+id+" cannot be found."));
        serviceRepo.delete(service);
    }
}

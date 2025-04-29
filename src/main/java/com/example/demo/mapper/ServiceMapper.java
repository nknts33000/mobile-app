package com.example.demo.mapper;

import com.example.demo.entities.BuildingService;
import com.example.demo.service.ServiceAdditionDTO;
import com.example.demo.service.ServiceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomMapper.class)
public interface ServiceMapper {
    @Mapping(source = "technician.userId", target = "userId")
    ServiceDTO toDto(BuildingService service);
    BuildingService toService(ServiceDTO serviceDTO);
    BuildingService toServiceFromAdditionDTO(ServiceAdditionDTO serviceAdditionDTO);
}

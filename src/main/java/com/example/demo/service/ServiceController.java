package com.example.demo.service;

import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.LinkOption;

@RestController
@RequestMapping(path="/api/v1/service")
public class ServiceController {
    public final ServiceService service;

    @Autowired
    public ServiceController(ServiceService service){
        this.service=service;
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceDTO> addService(@RequestBody ServiceAdditionDTO serviceDTO){
        ServiceDTO addedService=service.addService(serviceDTO);
        return new ResponseEntity<>(addedService,HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceDTO> findService(@PathVariable long id){
        ServiceDTO foundService=service.findService(id);
        return new ResponseEntity<>(foundService,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceDTO> updateService(@RequestBody ServiceDTO serviceDTO){
        ServiceDTO updatedService=service.updateService(serviceDTO);
        return new ResponseEntity<>(updatedService,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteService(@PathVariable long id){
        service.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

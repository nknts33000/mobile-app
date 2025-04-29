package com.example.demo.service;

import com.example.demo.entities.BuildingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<BuildingService,Long> {
}

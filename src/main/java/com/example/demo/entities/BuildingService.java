package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="services")
public class BuildingService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long serviceId;
    private String description;
    private String category;
    @ManyToOne
    @JoinColumn(name = "technicianId",referencedColumnName = "userId")
    private User technician;
}

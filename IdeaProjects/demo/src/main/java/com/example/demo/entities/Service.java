package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long serviceId;
    private String description;
    private String category;
    @ManyToOne
    @JoinColumn(name = "technicianId",referencedColumnName = "userId")
    private User technician;
}

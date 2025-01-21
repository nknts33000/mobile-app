package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long projectId;
    private boolean accepted;
    private boolean paymentOk;
    private float price;
    private String description;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="customerId",referencedColumnName = "userId")
    User customer;

    @ManyToOne
    @JoinColumn(name="technicianId",referencedColumnName = "userId")
    User technician;
}

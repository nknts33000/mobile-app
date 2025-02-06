package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private boolean active;
    private Date dateOfBirth;
    private enum Role{ADMIN,TECHNICIAN,CUSTOMER};
    private Role role;

    @OneToMany(mappedBy="customer")
    private TreeSet<Project> orders;

    @OneToMany(mappedBy="technician")
    private TreeSet<Project> projects;

    @OneToMany(mappedBy="technician")
    private TreeSet<Service> services;

    @OneToMany(mappedBy = "sender")
    private TreeSet<Message> sentMessages;

    @OneToMany(mappedBy = "receiver")
    private TreeSet<Message> receivedMessages;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Chat> chats;
}

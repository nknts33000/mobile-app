package com.example.demo.entities;

import com.example.demo.Utils.Role;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    @JsonIgnore
    private String password;
    private String name;
    private String surname;
    private String email;
    private boolean active;
    private Date dateOfBirth;
    private Role role;

    @OneToMany(mappedBy="customer")
    private SortedSet<Project> orders;

    @OneToMany(mappedBy="technician")
    private SortedSet<Project> projects;

    @OneToMany(mappedBy="technician")
    private SortedSet<BuildingService> services;

    @OneToMany(mappedBy = "sender")
    private SortedSet<Message> sentMessages;

    @OneToMany(mappedBy = "receiver")
    private SortedSet<Message> receivedMessages;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Chat> chats;
}

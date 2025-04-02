package com.example.demo.entities;

import com.example.demo.Utils.Role;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
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


//    public User(String username, String password, String name,
//                String surname, String email, Date dateOfBirth, Role role) {
//        this.username = username;
//        this.password=password;
//        this.name=name;
//        this.surname=surname;
//        this.email=email;
//        this.active=false;
//        this.dateOfBirth=dateOfBirth;
//        this.role= role;
//    }
}

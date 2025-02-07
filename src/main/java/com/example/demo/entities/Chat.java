package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long chatId;

    @ManyToOne
    @JoinColumn(name = "user1Id",referencedColumnName = "userId")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user2Id",referencedColumnName = "userId")
    private User user2;
    @OneToMany
    List<Message> messages;

}

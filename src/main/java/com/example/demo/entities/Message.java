package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long messageId;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "senderId",referencedColumnName = "userId")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id",referencedColumnName = "userId")
    private User receiver;
}

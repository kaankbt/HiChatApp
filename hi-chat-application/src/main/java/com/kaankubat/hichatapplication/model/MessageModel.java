package com.kaankubat.hichatapplication.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "messages")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    String senderName;

    @NotNull
    String receiverName;

    @NotNull
    String messageContent;
}

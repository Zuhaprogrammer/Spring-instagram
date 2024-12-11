package com.zuhriddin.spring_instagram.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String text;
    @OneToOne
    private Content content;
    @ManyToOne
    private User user;
    @ManyToOne
    private Chat chat;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

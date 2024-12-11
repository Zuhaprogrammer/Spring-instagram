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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String text;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

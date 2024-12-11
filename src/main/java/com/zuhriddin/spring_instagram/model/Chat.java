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
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

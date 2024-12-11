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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    @OneToOne
    private Content content;
    private String link;
    private LocalDateTime createdDate;
    private LocalDateTime lastActive;
}

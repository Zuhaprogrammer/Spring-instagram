package com.zuhriddin.spring_instagram.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Content> contents;
    private String location;
    @ManyToOne
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

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
public class Saved {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @ManyToMany
    private List<Post> posts;
    @ManyToOne
    private User user;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

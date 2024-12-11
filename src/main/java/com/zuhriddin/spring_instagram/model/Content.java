package com.zuhriddin.spring_instagram.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String contentName;
    private String contentPath;
    private String contentType;
    private String contentSize;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}

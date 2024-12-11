package com.zuhriddin.spring_instagram.model;

import com.zuhriddin.spring_instagram.model.enumeration.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String settings;
}

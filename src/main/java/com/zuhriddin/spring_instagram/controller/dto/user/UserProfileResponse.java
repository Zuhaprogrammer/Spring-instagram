package com.zuhriddin.spring_instagram.controller.dto.user;

import com.zuhriddin.spring_instagram.model.Content;
import com.zuhriddin.spring_instagram.model.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProfileResponse {
    private UUID id;
    private String fullName;
    private String username;
    private String bio;
    private String link;
    private String email;
    private Gender gender;
    private Content content;
    private LocalDateTime createdDate;
    private LocalDateTime lastActive;
}

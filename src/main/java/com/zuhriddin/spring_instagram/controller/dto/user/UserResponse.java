package com.zuhriddin.spring_instagram.controller.dto.user;

import com.zuhriddin.spring_instagram.model.Content;
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
public class UserResponse {
    private UUID id;
    private String fullName;
    private String username;
    private Content content;
    private LocalDateTime lastActive;
}

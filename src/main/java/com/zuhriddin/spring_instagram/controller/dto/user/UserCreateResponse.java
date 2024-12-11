package com.zuhriddin.spring_instagram.controller.dto.user;

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
public class UserCreateResponse {
    private UUID id;
    private String fullName;
    private String username;
    private LocalDateTime lastActive;
}

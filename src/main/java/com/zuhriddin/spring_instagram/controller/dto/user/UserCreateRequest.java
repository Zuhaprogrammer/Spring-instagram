package com.zuhriddin.spring_instagram.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRequest {
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String password;
    private String gender;
}

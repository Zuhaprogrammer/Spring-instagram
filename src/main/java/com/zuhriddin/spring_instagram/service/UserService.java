package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.controller.dto.user.UserCreateRequest;
import com.zuhriddin.spring_instagram.controller.dto.user.UserCreateResponse;
import com.zuhriddin.spring_instagram.controller.dto.user.UserLoginRequest;
import com.zuhriddin.spring_instagram.model.User;
import com.zuhriddin.spring_instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserCreateResponse save(UserCreateRequest userCreateRequest) {
        User user = User.builder()
                .fullName(userCreateRequest.getFirstName() + " " + userCreateRequest.getLastName())
                .username(userCreateRequest.getNickname())
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getPassword())
                .createdDate(LocalDateTime.now())
                .build();

        User save = userRepository.save(user);

        return UserCreateResponse.builder()
                .id(save.getId())
                .fullName(save.getFullName())
                .username(save.getUsername())
                .lastActive(save.getLastActive())
                .build();
    }

    public Optional<User> checkUserByUsernameAndPassword(UserLoginRequest userLoginRequest) {
        return userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
    }
}

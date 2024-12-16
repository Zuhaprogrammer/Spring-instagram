package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.controller.dto.user.UserCreateRequest;
import com.zuhriddin.spring_instagram.controller.dto.user.UserProfileResponse;
import com.zuhriddin.spring_instagram.controller.dto.user.UserResponse;
import com.zuhriddin.spring_instagram.controller.dto.user.UserLoginRequest;
import com.zuhriddin.spring_instagram.exceptions.RecordNotFoundException;
import com.zuhriddin.spring_instagram.model.User;
import com.zuhriddin.spring_instagram.model.enumeration.Gender;
import com.zuhriddin.spring_instagram.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse save(UserCreateRequest userCreateRequest) {
        User user = User.builder()
                .fullName(userCreateRequest.getFirstName() + " " + userCreateRequest.getLastName())
                .username(userCreateRequest.getNickname())
                .email(userCreateRequest.getEmail())
                .password(userCreateRequest.getPassword())
                .gender(userCreateRequest.getGender().equals("male") ? Gender.MALE : Gender.FEMALE)
                .createdDate(LocalDateTime.now())
                .build();

        User save = userRepository.save(user);

        return UserResponse.builder()
                .id(save.getId())
                .fullName(save.getFullName())
                .username(save.getUsername())
                .lastActive(save.getLastActive())
                .build();
    }

    public UserResponse get(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("User not found exception"));
        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .content(user.getContent())
                .lastActive(user.getLastActive())
                .build();
    }

    public Optional<User> checkUserByUsernameAndPassword(UserLoginRequest userLoginRequest) {
        return userRepository.findByEmailAndPassword(userLoginRequest.getEmail(), userLoginRequest.getPassword());
    }

    public UserProfileResponse getUserForProfile(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("User not found!"));
        return UserProfileResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(user.getBio())
                .link(user.getLink())
                .gender(user.getGender())
                .content(user.getContent())
                .createdDate(user.getCreatedDate())
                .lastActive(user.getLastActive())
                .build();
    }

    public void saveOwnerToCookie(HttpServletResponse response, Optional<User> user) {
        if (user.isPresent()) {
            Cookie cookie = new Cookie("ownerId", user.get().getId().toString());
            cookie.setMaxAge(5 * 60);
            response.addCookie(cookie);
        }
    }

    public UUID getOwnerIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("ownerId")) {
                return UUID.fromString(cookie.getValue());
            }
        }
        return null;
    }

    public List<UserResponse> getResultOfSearch(String search) {
        List<User> users = new ArrayList<>();
        if (search.charAt(0) == '@') {
            users = userRepository.findAllByLinkContains(search.substring(1));
        } else {
            users = userRepository.findAllByUsernameContains(search);
        }
        return users.stream().map(u -> {
            return UserResponse.builder()
                    .id(u.getId())
                    .fullName(u.getFullName())
                    .username(u.getUsername())
                    .content(u.getContent())
                    .lastActive(u.getLastActive())
                    .build();
        }).collect(Collectors.toList());
    }
}

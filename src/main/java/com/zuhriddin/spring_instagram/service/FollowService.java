package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.controller.dto.user.UserResponse;
import com.zuhriddin.spring_instagram.model.Follow;
import com.zuhriddin.spring_instagram.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;

    public List<UserResponse> getFollowings(UUID userId) {
        List<Follow> allByFollowerId = followRepository.findAllByFollower_id(userId);
        return allByFollowerId.stream().map(f -> {
            return UserResponse.builder()
                    .id(f.getFollowing().getId())
                    .fullName(f.getFollowing().getFullName())
                    .username(f.getFollowing().getUsername())
                    .content(f.getFollowing().getContent())
                    .lastActive(f.getFollowing().getLastActive())
                    .build();
        }).collect(Collectors.toList());
    }
}

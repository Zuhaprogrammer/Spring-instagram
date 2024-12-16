package com.zuhriddin.spring_instagram.controller;

import com.zuhriddin.spring_instagram.controller.dto.user.UserResponse;
import com.zuhriddin.spring_instagram.service.FollowService;
import com.zuhriddin.spring_instagram.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowController {
    private final FollowService followService;
    private final UserService userService;

    @GetMapping("/{id}/following-list")
    public List<UserResponse> getFollowingsList(@PathVariable UUID id) {
        return followService.getFollowings(id);
    }

    @GetMapping("/{followingId}/existence")
    public boolean checkExistenceFollow(@PathVariable UUID followingId, HttpServletRequest request) {
        UUID followerId = userService.getOwnerIdFromCookie(request);
        return followService.checkExistenceFollowByFollowerIdAndFollowingId(followerId, followingId);
    }
}

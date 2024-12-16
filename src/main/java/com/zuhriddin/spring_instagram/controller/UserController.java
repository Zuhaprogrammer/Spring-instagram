package com.zuhriddin.spring_instagram.controller;

import com.zuhriddin.spring_instagram.controller.dto.user.UserProfileResponse;
import com.zuhriddin.spring_instagram.controller.dto.user.UserResponse;
import com.zuhriddin.spring_instagram.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}/profile")
    public String moveToProfilePage(@PathVariable UUID id, Model model, HttpServletRequest request) {
        UserProfileResponse profile = userService.getUserForProfile(id);
        model.addAttribute("ownerId", userService.getOwnerIdFromCookie(request));
        model.addAttribute("currentUser", profile);
        return "profile/profile";
    }

    @GetMapping("/search/{search}")
    @ResponseBody
    public List<UserResponse> getResultOfSearch(@PathVariable String search) {
        List<UserResponse> result = userService.getResultOfSearch(search);
        System.out.println(result);
        return result;
    }
}

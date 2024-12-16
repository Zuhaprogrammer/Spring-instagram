package com.zuhriddin.spring_instagram.controller;

import com.zuhriddin.spring_instagram.controller.dto.user.UserResponse;
import com.zuhriddin.spring_instagram.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/{id}")
    public String moveToHomePage(@PathVariable("id")UUID id, Model model) {
        UserResponse response = userService.get(id);
        model.addAttribute("currentUser", response);
        return "home/home";
    }
}

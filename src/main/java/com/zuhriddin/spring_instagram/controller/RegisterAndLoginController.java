package com.zuhriddin.spring_instagram.controller;

import com.zuhriddin.spring_instagram.controller.dto.user.UserCreateRequest;
import com.zuhriddin.spring_instagram.controller.dto.user.UserLoginRequest;
import com.zuhriddin.spring_instagram.model.User;
import com.zuhriddin.spring_instagram.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RegisterAndLoginController {
    private final UserService userService;

    @GetMapping("/")
    public String moveToRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserCreateRequest userCreateRequest) {
        userService.save(userCreateRequest);
        return "redirect:/login-page";
    }

    @GetMapping("/login-page")
    public String moveToLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginRequest userLoginRequest, HttpServletResponse response) {
        Optional<User> user = userService.checkUserByUsernameAndPassword(userLoginRequest);
        userService.saveOwnerToCookie(response, user);
        return user.map(value -> "redirect:/home/" + value.getId()).orElse("redirect:/");
    }
}

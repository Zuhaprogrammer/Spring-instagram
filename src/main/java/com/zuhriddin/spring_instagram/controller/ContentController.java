package com.zuhriddin.spring_instagram.controller;

import com.zuhriddin.spring_instagram.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.util.UUID;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping("/{name}")
    public ResponseEntity<?> getContent(@PathVariable String name) throws MalformedURLException {
        return contentService.getContent(name);
    }
}

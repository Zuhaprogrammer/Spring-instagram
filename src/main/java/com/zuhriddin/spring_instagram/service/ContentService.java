package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.exceptions.RecordNotFoundException;
import com.zuhriddin.spring_instagram.model.Content;
import com.zuhriddin.spring_instagram.model.User;
import com.zuhriddin.spring_instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final UserRepository userRepository;

    private static final String UPLOAD_PATH = "contents/user_profile_images";

    public ResponseEntity<?> getContent(String name) throws MalformedURLException {
        Path path = Paths.get(UPLOAD_PATH).resolve(name).normalize();
        Resource resource = new UrlResource(path.toUri());
        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

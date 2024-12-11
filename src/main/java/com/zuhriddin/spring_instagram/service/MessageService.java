package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

}

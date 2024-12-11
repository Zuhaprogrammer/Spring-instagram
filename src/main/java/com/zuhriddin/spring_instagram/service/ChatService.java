package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

}

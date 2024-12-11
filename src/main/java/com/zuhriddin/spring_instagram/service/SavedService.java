package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.repository.SavedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavedService {
    private final SavedRepository savedRepository;

}

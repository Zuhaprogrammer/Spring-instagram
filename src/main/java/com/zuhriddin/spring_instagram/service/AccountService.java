package com.zuhriddin.spring_instagram.service;

import com.zuhriddin.spring_instagram.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

}

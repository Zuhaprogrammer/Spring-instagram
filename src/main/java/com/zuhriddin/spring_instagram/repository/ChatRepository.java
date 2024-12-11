package com.zuhriddin.spring_instagram.repository;

import com.zuhriddin.spring_instagram.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<Chat, UUID> {

}

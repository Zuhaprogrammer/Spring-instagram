package com.zuhriddin.spring_instagram.repository;

import com.zuhriddin.spring_instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailAndPassword(String email, String password);
    List<User> findAllByLinkContains(String link);
    List<User> findAllByUsernameContains(String username);
}

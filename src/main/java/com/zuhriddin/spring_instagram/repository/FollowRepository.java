package com.zuhriddin.spring_instagram.repository;

import com.zuhriddin.spring_instagram.model.Follow;
import com.zuhriddin.spring_instagram.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FollowRepository extends JpaRepository<Follow, UUID> {
    List<Follow> findAllByFollower_id(UUID id);
    Optional<Follow> findByFollower_idAndFollowing_id(UUID followerId, UUID followingId);
}

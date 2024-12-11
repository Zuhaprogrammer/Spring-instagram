package com.zuhriddin.spring_instagram.repository;

import com.zuhriddin.spring_instagram.model.Saved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SavedRepository extends JpaRepository<Saved, UUID> {

}

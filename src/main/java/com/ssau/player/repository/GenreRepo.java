package com.ssau.player.repository;

import com.ssau.player.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<GenreEntity, String> {
}

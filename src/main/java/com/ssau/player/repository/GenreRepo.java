package com.ssau.player.repository;

import com.ssau.player.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<GenreEntity, String> {
}

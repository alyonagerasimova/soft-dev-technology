package com.ssau.player.repository;

import com.ssau.player.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<SongEntity, String> {
}

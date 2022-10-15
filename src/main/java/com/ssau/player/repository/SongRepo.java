package com.ssau.player.repository;

import com.ssau.player.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<SongEntity, String> {
    SongEntity getSongById(String id);
}

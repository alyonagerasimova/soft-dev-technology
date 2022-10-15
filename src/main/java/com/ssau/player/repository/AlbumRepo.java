package com.ssau.player.repository;

import com.ssau.player.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepo extends JpaRepository<AlbumEntity, String> {
}

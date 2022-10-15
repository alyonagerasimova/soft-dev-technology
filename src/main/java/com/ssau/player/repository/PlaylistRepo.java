package com.ssau.player.repository;

import com.ssau.player.entity.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepo extends JpaRepository<PlaylistEntity, String> {
    PlaylistEntity findPlaylistById(String id);
}

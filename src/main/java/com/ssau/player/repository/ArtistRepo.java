package com.ssau.player.repository;

import com.ssau.player.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends JpaRepository<ArtistEntity, String> {
    ArtistEntity getArtistById(String id);
}

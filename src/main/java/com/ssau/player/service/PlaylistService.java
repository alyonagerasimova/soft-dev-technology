package com.ssau.player.service;

import com.ssau.player.entity.PlaylistEntity;
import com.ssau.player.entity.UserEntity;
import com.ssau.player.model.Playlist;
import com.ssau.player.repository.PlaylistRepo;
import com.ssau.player.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepo playlistRepo;
    @Autowired
    private UserRepo userRepo;

    public Playlist createPlaylist(PlaylistEntity playlist, String userId) {
        UserEntity user = userRepo.findById(userId).get();
        playlist.setUser(user);
        return Playlist.toModel(playlistRepo.save(playlist));
    }

    public String delete(String id) {
        playlistRepo.deleteById(id);
        return id;
    }
}

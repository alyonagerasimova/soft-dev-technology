package com.ssau.player.service;

import com.ssau.player.dto.PlaylistDto;
import com.ssau.player.entity.PlaylistEntity;
import com.ssau.player.entity.UserEntity;
import com.ssau.player.repository.PlaylistRepo;
import com.ssau.player.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepo playlistRepo;
    private final UserRepo userRepo;

    public PlaylistDto createPlaylist(PlaylistEntity playlist, String userId) {
        UserEntity user = userRepo.findById(userId).get();
        playlist.setUser(user);
        return PlaylistDto.fromPlaylistEntity(playlistRepo.save(playlist));
    }

    public String delete(String id) {
        playlistRepo.deleteById(id);
        return id;
    }

//    public List<Playlist> getPlaylists(String name) {
//
//    }

    public PlaylistDto getPlaylist(String id) {
        PlaylistEntity playlist = playlistRepo.findPlaylistById(id);
        return PlaylistDto.fromPlaylistEntity(playlist);
    }
}

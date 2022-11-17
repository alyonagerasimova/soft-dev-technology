package com.ssau.player.controller;

import com.ssau.player.dto.ArtistDto;
import com.ssau.player.dto.PlaylistDto;
import com.ssau.player.dto.SongDto;
import com.ssau.player.service.ArtistService;
import com.ssau.player.service.PlaylistService;
import com.ssau.player.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/home")
@RequiredArgsConstructor
public class MainPageController {
    private final ArtistService artistService;
    private final PlaylistService playlistService;
    private final SongService songService;

    @GetMapping
    public List<SongDto> getSongs() {
        return songService.getSongs();
    }

    @GetMapping
    public List<PlaylistDto> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @GetMapping
    public List<ArtistDto> getArtists() {
        return artistService.getArtists();
    }
}

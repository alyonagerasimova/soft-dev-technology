package com.ssau.player.controller;

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
public class HomeController {
    private final ArtistService artistService;
    private final PlaylistService playlistService;
    private final SongService songService;

    @GetMapping
    public List<?>[] getData() {
        return new List[]{songService.getSongs(), playlistService.getPlaylists(), artistService.getArtists()};
    }

}

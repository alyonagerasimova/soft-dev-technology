package com.ssau.player.controller;

import com.ssau.player.dto.PlaylistDto;
import com.ssau.player.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

//    @GetMapping
//    public List<PlaylistDto> getPlaylists() {
//        return playlistService.getPlaylists();
//    }

    @GetMapping(path = "/{id}")
    public PlaylistDto getPlaylist(@PathVariable String id) {
        return playlistService.getPlaylist(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public PlaylistDto create(@RequestBody PlaylistDto dto) {
        if (dto.getId() != null) {
            dto.setId(null);
        }
        return playlistService.save(dto);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePlaylist(@PathVariable String id){
       playlistService.delete(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PlaylistDto update(@PathVariable String id,@RequestBody PlaylistDto dto) {
        dto.setId(id);
        return playlistService.save(dto);
    }

}

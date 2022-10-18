package com.ssau.player.controller;

import com.ssau.player.dto.SongDto;
import com.ssau.player.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;

    @GetMapping
    public List<SongDto> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public SongDto getSong(@PathVariable String id) {
        return songService.getSong(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SongDto create(@RequestBody SongDto dto) {
        if (dto.getId() != null) {
            dto.setId(null);
        }
        return songService.save(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public SongDto update(@PathVariable String id,@RequestBody SongDto dto) {
        dto.setId(id);
        return songService.save(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String id) {
        songService.delete(id);
    }
}

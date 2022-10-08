package com.ssau.player.controller;

import com.ssau.player.dto.ArtistDto;
import com.ssau.player.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public List<ArtistDto> getArtists() {
        return artistService.getArtists();
    }

    @GetMapping("/{id}")
    public ArtistDto getArtist(@PathVariable String id) {
        return artistService.getArtist(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ArtistDto create(@RequestBody ArtistDto dto) {
        if (dto.getId() != null) {
            dto.setId(null);
        }
        return artistService.save(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ArtistDto update(@PathVariable String id,@RequestBody ArtistDto dto) {
        dto.setId(id);
        return artistService.save(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String id) {
        artistService.delete(id);
    }
}

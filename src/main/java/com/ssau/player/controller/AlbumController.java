package com.ssau.player.controller;

import com.ssau.player.dto.AlbumDto;
import com.ssau.player.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping
    public List<AlbumDto> getAlbums() {
        return albumService.getAlbums();
    }

    @GetMapping("/{id}")
    public AlbumDto getAlbum(@PathVariable String id) {
        return albumService.getAlbum(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AlbumDto create(@RequestBody AlbumDto dto) {
        if (dto.getId() != null) {
            dto.setId(null);
        }
        return albumService.save(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public AlbumDto update(@PathVariable String id,@RequestBody AlbumDto dto) {
        dto.setId(id);
        return albumService.save(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable String id) {
        albumService.delete(id);
    }
}

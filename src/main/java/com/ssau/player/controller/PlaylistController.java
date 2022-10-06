package com.ssau.player.controller;

import com.ssau.player.entity.PlaylistEntity;
import com.ssau.player.entity.UserEntity;
import com.ssau.player.exception.UserEmailAlreadyExistException;
import com.ssau.player.exception.UserNotFoundException;
import com.ssau.player.service.PlaylistService;
import com.ssau.player.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    @PostMapping
    public ResponseEntity createPlaylist(@RequestBody PlaylistEntity playlist,
                                         @RequestParam String userId){
        try {
           return ResponseEntity.ok(playlistService.createPlaylist(playlist, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlaylist(@PathVariable String id){
        try {
            return ResponseEntity.ok(playlistService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}

package com.ssau.player.model;

import com.ssau.player.entity.PlaylistEntity;
import lombok.Data;

public class Playlist {
    private String id;
    private String playlistName;

    public Playlist(){}

    public static Playlist toModel(PlaylistEntity playlist){
        Playlist model = new Playlist();
        model.setId(playlist.getId());
        model.setPlaylistName(playlist.getPlaylistName());
        return model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}

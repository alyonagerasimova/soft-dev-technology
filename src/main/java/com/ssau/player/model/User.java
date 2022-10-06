package com.ssau.player.model;

import com.ssau.player.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private String id;
    private String email;
    private List<Playlist> playlists;

    public User() {
    }

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setPlaylists(entity.getPlaylists().stream().map(Playlist::toModel).collect(Collectors.toList()));
        return model;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}

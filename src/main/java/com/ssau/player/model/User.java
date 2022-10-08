package com.ssau.player.model;

import com.ssau.player.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.*;

@lombok.Data
@Getter
@Setter
public class User {
//    private String id;
    private String email;
    private String password;
//    private List<Playlist> playlists;

    public User() {
    }

    public static User toModel(UserEntity entity){
        User model = new User();
//        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setPassword(entity.getPassword());
//        model.setPlaylists(entity.getPlaylists().stream().map(Playlist::toModel).collect(Collectors.toList()));
        return model;
    }
}

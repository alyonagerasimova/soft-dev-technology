package com.ssau.player.dto;

import com.ssau.player.entity.SongEntity;
import lombok.Data;

@Data
public class SongDto {
    private String id;
    private String songName;
    private String coverUrl;


    public SongEntity toSongEntity(){
        SongEntity song = new SongEntity();
        song.setId(id);
        song.setSongName(songName);
        song.setCover(coverUrl);
        return song;
    }

    public static SongDto fromSongEntity(SongEntity artist){
        SongDto songDto = new SongDto();
        songDto.setId(artist.getId());
        songDto.setSongName(songDto.getSongName());
        songDto.setCoverUrl(songDto.getCoverUrl());
        return songDto;
    }
}

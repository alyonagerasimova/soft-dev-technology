package com.ssau.player.dto;

import com.ssau.player.entity.AlbumEntity;
import lombok.Data;

@Data
public class AlbumDto {
    private String id;
    private String name;

    public AlbumEntity toAlbumEntity(){
        AlbumEntity album = new AlbumEntity();
        album.setAlbumName(name);
        album.setId(id);
        return album;
    }

    public static AlbumDto fromAlbumEntity(AlbumEntity album){
        AlbumDto albumDto = new AlbumDto();
        albumDto.setId(album.getId());
        albumDto.setName(albumDto.getName());
        return albumDto;
    }
}

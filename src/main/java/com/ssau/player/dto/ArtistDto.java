package com.ssau.player.dto;

import com.ssau.player.entity.ArtistEntity;
import lombok.Data;

@Data
public class ArtistDto {
    private String id;
    private String name;

    public ArtistEntity toArtistEntity(){
        ArtistEntity artist = new ArtistEntity();
        artist.setArtistName(name);
        artist.setId(id);
        return artist;
    }

    public static ArtistDto fromArtistEntity(ArtistEntity artist){
        ArtistDto artistDto = new ArtistDto();
        artistDto.setId(artist.getId());
        artistDto.setName(artistDto.getName());
        return artistDto;
    }
}

package com.ssau.player.dto;

import com.ssau.player.entity.ArtistEntity;
import lombok.Data;

@Data
public class ArtistDto {
    private String id;
    private String artistName;

    public ArtistEntity toArtistEntity(){
        ArtistEntity artist = new ArtistEntity();
        artist.setArtistName(artistName);
        artist.setId(id);
        return artist;
    }

    public static ArtistDto fromArtistEntity(ArtistEntity artist){
        ArtistDto artistDto = new ArtistDto();
        artistDto.setId(artist.getId());
        artistDto.setArtistName(artistDto.getArtistName());
        return artistDto;
    }
}

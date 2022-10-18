package com.ssau.player.dto;

import com.ssau.player.entity.GenreEntity;
import lombok.Data;

@Data
public class GenreDto {
    private String id;
    private String name;

    public GenreEntity toGenreEntity(){
        GenreEntity genre = new GenreEntity();
        genre.setGenreName(name);
        genre.setId(id);
        return genre;
    }

    public static GenreDto fromGenreEntity(GenreEntity album){
        GenreDto genreDto = new GenreDto();
        genreDto.setId(album.getId());
        genreDto.setName(genreDto.getName());
        return genreDto;
    }
}

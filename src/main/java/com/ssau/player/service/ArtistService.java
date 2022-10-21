package com.ssau.player.service;

import com.ssau.player.dto.AlbumDto;
import com.ssau.player.dto.ArtistDto;
import com.ssau.player.repository.ArtistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepo artistRepo;
    private final DataSource dataSource;

    public List<ArtistDto> getArtists(){
        return artistRepo.findAll().stream().map(ArtistDto::fromArtistEntity).collect(Collectors.toList());
    }

    public ArtistDto getArtist(String id){
        return ArtistDto.fromArtistEntity(artistRepo.getArtistById(id));
    }

    public ArtistDto save(ArtistDto artistDto){
        return ArtistDto.fromArtistEntity(artistRepo.save(artistDto.toArtistEntity()));
    }

    public void delete(String id){
        artistRepo.deleteById(id);
    }

    public List<ArtistDto> select() {
        return new NamedParameterJdbcTemplate(dataSource)
                .query("select id, artist_name from artists", Collections.emptyMap(), (rs, rowNum) -> {
                    ArtistDto artist = new ArtistDto();
                    artist.setId(rs.getString("id"));
                    artist.setArtistName(rs.getString("artist_name"));
                    return artist;
                });
    }
}

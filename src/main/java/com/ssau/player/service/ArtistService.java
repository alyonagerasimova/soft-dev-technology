package com.ssau.player.service;

import com.ssau.player.dto.ArtistDto;
import com.ssau.player.repository.ArtistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepo artistRepo;

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
}

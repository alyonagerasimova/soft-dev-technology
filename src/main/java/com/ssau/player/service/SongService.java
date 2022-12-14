package com.ssau.player.service;

import com.ssau.player.dto.SongDto;
import com.ssau.player.repository.SongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepo songRepo;

    public List<SongDto> getSongs(){
        return songRepo.findAll().stream().map(SongDto::fromSongEntity).collect(Collectors.toList());
    }

    public SongDto getSong(String id){
        return SongDto.fromSongEntity(songRepo.getSongById(id));
    }

    public SongDto save(SongDto songDto){
        return SongDto.fromSongEntity(songRepo.save(songDto.toSongEntity()));
    }

    public void delete(String id){
        songRepo.deleteById(id);
    }
}

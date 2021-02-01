package com.ramich.MusicList.services.impl;

import com.ramich.MusicList.entities.Song;
import com.ramich.MusicList.repositories.SongRepository;
import com.ramich.MusicList.services.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getAllSongs() {
        List<Song> songs = songRepository.findAll();
        return songs;
    }

    @Override
    public Optional<Song> getSong(int id) {
        Optional<Song> someSong = songRepository.findById(id);
        return someSong;
    }

    @Override
    public List<Song> findAllSongsByArtist(int artistId) {
        List<Song> songs = songRepository.findByArtist(artistId);
        return songs;
    }

    @Override
    public List<Song> findAllSongsByAlbum(int album) {
        List<Song> songs = songRepository.findByAlbum(album);
        return songs;
    }
}

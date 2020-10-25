package com.ramich.MusicList.services;

import com.ramich.MusicList.entities.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> getAllSongs();
    Optional<Song> getSong(int id);
    List<Song> findAllSongsByArtist(int artist);
    List<Song> findAllSongsByAlbum(int album);
}

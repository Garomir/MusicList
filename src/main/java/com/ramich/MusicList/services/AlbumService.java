package com.ramich.MusicList.services;

import com.ramich.MusicList.entities.Album;
import com.ramich.MusicList.entities.Song;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    Optional<Album> getAlbum(int id);
    List<Album> findAllAlbumsByArtist(int artist);
}

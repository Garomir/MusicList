package com.ramich.MusicList.services.impl;

import com.ramich.MusicList.entities.Album;
import com.ramich.MusicList.repositories.AlbumRepository;
import com.ramich.MusicList.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Optional<Album> getAlbum(int id) {
        Optional<Album> someAlbum = albumRepository.findById(id);
        return someAlbum;
    }

    @Override
    public List<Album> findAllAlbumsByArtist(int artist) {
        List<Album> albums = albumRepository.findAlbumsByArtist(artist);
        return albums;
    }
}

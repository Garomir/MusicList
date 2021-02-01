package com.ramich.MusicList.services.impl;

import com.ramich.MusicList.entities.Artist;
import com.ramich.MusicList.repositories.ArtistRepository;
import com.ramich.MusicList.services.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public List<Artist> getAllArtist() {
        List<Artist> artists = artistRepository.findAll();
        return artists;
    }
}

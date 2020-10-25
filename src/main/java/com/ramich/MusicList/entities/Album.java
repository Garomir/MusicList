package com.ramich.MusicList.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String album_src;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    @JsonIgnore
    private Artist artist;

    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Song> songs;

    public Album() {
    }

    public Album(String name, String album_src, Artist artist) {
        this.name = name;
        this.album_src = album_src;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum_src() {
        return album_src;
    }

    public void setAlbum_src(String album_src) {
        this.album_src = album_src;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        artist.getAlbums();
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
        for (Song song : songs){
            song.setAlbum(this);
        }
    }
}

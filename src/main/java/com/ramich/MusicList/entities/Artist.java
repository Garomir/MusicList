package com.ramich.MusicList.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Song> songs;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Album> albums;

    public Artist(){
        songs = new HashSet<>();
    }

    public Artist(String name){
        this.name = name;
        songs = new HashSet<>();
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

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
        for (Song song : songs){
            song.setArtist(this);
        }
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
        for (Album album : albums){
            album.setArtist(this);
        }
    }
}

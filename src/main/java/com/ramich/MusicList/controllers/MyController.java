package com.ramich.MusicList.controllers;

import com.ramich.MusicList.entities.Album;
import com.ramich.MusicList.entities.Artist;
import com.ramich.MusicList.entities.Song;
import com.ramich.MusicList.repositories.SongRepository;
import com.ramich.MusicList.services.AlbumService;
import com.ramich.MusicList.services.ArtistService;
import com.ramich.MusicList.services.SongService;
import com.ramich.MusicList.utils.MediaTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MyController {

    private static final String DIRECTORY = "C:\\Proj\\MusicList\\Music";

    @Autowired
    private SongService songService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> findAllSongs(){
        List<Song> songs = songService.getAllSongs();
        return ResponseEntity.ok().body(songs);
    }

    @GetMapping("songs/artist/{artist}")
    public ResponseEntity<List<Song>> findSongsByArtist(@PathVariable("artist")int artist){
        List<Song> songs = songService.findAllSongsByArtist(artist);
        return ResponseEntity.ok().body(songs);
    }

    @GetMapping("/albums/{artist}")
    public ResponseEntity<List<Album>> findAlbumsByArtist(@PathVariable("artist")int artist){
        List<Album> albums = albumService.findAllAlbumsByArtist(artist);
        return ResponseEntity.ok().body(albums);
    }

    @GetMapping("songs/album/{album}")
    public ResponseEntity<List<Song>> findSongsByAlbum(@PathVariable("album")int album){
        List<Song> songs = songService.findAllSongsByAlbum(album);
        return ResponseEntity.ok().body(songs);
    }

    @GetMapping("/artist")
    public ResponseEntity<List<Artist>> findAllArtists(){
        List<Artist> artists = artistService.getAllArtist();
        return ResponseEntity.ok().body(artists);
    }

    @GetMapping("/songs/{songId}")
    public ResponseEntity<InputStreamResource> downloadFile1(@PathVariable("songId") int songId) throws IOException, EntityNotFoundException  {
        Optional<Song> song = songService.getSong(songId);
        if (!song.isPresent()) throw new EntityNotFoundException("id-" + songId);

        String fileName = song.get().getName() + ".mp3";
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + "\\" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }

    @GetMapping("/albums/img/{img}")
    public ResponseEntity<InputStreamResource> downloadImg(@PathVariable("img") int img) throws IOException, EntityNotFoundException  {
        Optional<Album> album = albumService.getAlbum(img);
        if (!album.isPresent()) throw new EntityNotFoundException("id-" + img);

        String fileName = album.get().getAlbum_src();
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + "\\Albums\\" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }
}

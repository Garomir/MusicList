package com.ramich.MusicList.repositories;

import com.ramich.MusicList.entities.Album;
import com.ramich.MusicList.entities.Artist;
import com.ramich.MusicList.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "select * from albums where artist_id = :artistId",nativeQuery = true)
    List<Album> findAlbumsByArtist(@Param("artistId") int artistId);
}

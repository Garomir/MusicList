package com.ramich.MusicList.repositories;

import com.ramich.MusicList.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    @Query(value = "select * from songs where artist_id = :artistId",nativeQuery = true)
    List<Song> findByArtist(@Param("artistId") int artistId);

    @Query(value = "select * from songs where album_id = :albumId",nativeQuery = true)
    List<Song> findByAlbum(@Param("albumId") int albumId);
}

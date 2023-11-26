package com.example.spotifybackend.dao;

import com.example.spotifybackend.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface SongsDao extends JpaRepository<Song,Long> {

    @Query(value = "SELECT * FROM SONGS S WHERE S.GENRE=:genre",nativeQuery = true)
    List<Song> getSongsByGenre(String genre);

    @Query(value = "SELECT * FROM SONGS S WHERE S.song_name=:songName",nativeQuery = true)
    Optional<Song> getSongByName(String songName);

    @Query(value = "UPDATE SONGS SET FAVOURITE = CASE WHEN FAVOURITE = TRUE THEN FALSE WHEN FAVOURITE = FALSE THEN TRUE END WHERE ID=:id",nativeQuery = true)
    int changeFavouriteById(long id);

    @Query(value = "SELECT * FROM SONGS WHERE FAVOURITE = TRUE",nativeQuery = true)
    List<Song> getSongsByFavourite();
}


package com.example.spotifybackend.controller;

import com.example.spotifybackend.dao.SongsDao;
import com.example.spotifybackend.model.Song;
import com.example.spotifybackend.services.SongService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/songs")
public class SongController {

    private final SongsDao songsDao;

    SongController(SongsDao songsDao){
        this.songsDao=songsDao;
    }

    @GetMapping("/getSongById/{id}")
    public Optional<Song> getSongById(@PathVariable Long id){
        return songsDao.findById(id);
    }

    @GetMapping("/getSongsByGenre/{genre}")
    public List<Song> getSongsByGenre(@PathVariable String genre){
        return songsDao.getSongsByGenre(genre);
    }

    @GetMapping("/getSongByName/{songName}")
    public ResponseEntity<Song> getSongByName(@PathVariable String songName){
        try{
            Optional<Song> song = songsDao.getSongByName(songName);

            return song.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }catch (Exception e){
            System.out.println("error = "+e);
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/addSong")
    public Song addSong(@RequestBody Song song){
        return songsDao.save(song);
    }

    @PutMapping("/changeFavouriteById/{id}")
    public void changeFavouriteById(@PathVariable long id){
        songsDao.changeFavouriteById(id);
    }

}

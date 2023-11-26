package com.example.spotifybackend.controller;

import com.example.spotifybackend.dao.SongsDao;
import com.example.spotifybackend.model.Song;
import com.example.spotifybackend.services.SongService;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/getAllSongs")
    public List<Song> getAllSongs(){
        return songsDao.findAll();
    }
    @GetMapping("/getSongById/{id}")
    public Optional<Song> getSongById(@PathVariable Long id){
        return songsDao.findById(id);
    }


    @GetMapping("/getSongsByGenre/{genre}")
    public ResponseEntity<List<Song>> getSongsByGenre(@PathVariable String genre) {
        List<Song> songs = songsDao.getSongsByGenre(genre);

        if (songs != null && !songs.isEmpty()) {
            return new ResponseEntity<>(songs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/getSongsByFavourite")
    public ResponseEntity<List<Song>> getSongsByFavourite(){
        List<Song> songs = songsDao.getSongsByFavourite();

        if(songs != null && !songs.isEmpty()){
            return new ResponseEntity<>(songs,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

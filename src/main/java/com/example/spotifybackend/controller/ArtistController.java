package com.example.spotifybackend.controller;

import com.example.spotifybackend.dao.ArtistDao;
import com.example.spotifybackend.model.Artist;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistDao artistDao;

    public ArtistController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @GetMapping
    @ResponseBody
    public List<Artist> getAllArtists(){
        return artistDao.findAll();
    }

    @PostMapping
    public Artist addArtist(@RequestParam Artist artist){
        return artistDao.save(artist);
    }
}

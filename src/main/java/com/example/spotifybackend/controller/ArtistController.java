package com.example.spotifybackend.controller;

import com.example.spotifybackend.dao.ArtistDao;
import com.example.spotifybackend.model.Artist;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1//artist")
public class ArtistController {

    private final ArtistDao artistDao;

    public ArtistController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @GetMapping("/getAllArtists")
    @ResponseBody
    public List<Artist> getAllArtists(){
        return artistDao.findAll();
    }

    @PostMapping("/addArtist")
    public Artist addArtist(@RequestParam Artist artist){
        return artistDao.save(artist);
    }

}

package com.example.spotifybackend.services;

import com.example.spotifybackend.dao.SongsDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SongService {

    @Autowired
    private static SongsDao songsDao ;

    public static void favouriteToggle(long id){
        int rowsAffected = songsDao.changeFavouriteById(id);
    }


}

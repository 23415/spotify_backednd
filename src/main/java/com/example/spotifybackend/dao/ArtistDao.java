package com.example.spotifybackend.dao;

import com.example.spotifybackend.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDao extends JpaRepository<Artist,Long> {
}

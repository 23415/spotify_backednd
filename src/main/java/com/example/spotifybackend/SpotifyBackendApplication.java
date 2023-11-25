package com.example.spotifybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpotifyBackendApplication {

	@RequestMapping("/")
	String home(){
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpotifyBackendApplication.class, args);
	}

}

package com.example.cinema.services;

import com.example.cinema.models.Movie;
import com.example.cinema.models.Rating;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService() {

    }

    public void logMovie(Movie movie){
        movieRepository.save(movie);
    }

}

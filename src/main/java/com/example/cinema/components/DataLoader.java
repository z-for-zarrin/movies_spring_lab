package com.example.cinema.components;

import com.example.cinema.models.Movie;
import com.example.cinema.models.Rating;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Movie movie1 = new Movie("Eternal Sunshine of the Spotless Mind", Rating.FIFTEEN, 108);
        Movie movie2 = new Movie("Ratatouille", Rating.PG, 111);
        Movie movie3 = new Movie("Fight Club", Rating.EIGHTEEN, 139);
        Movie movie4 = new Movie("Spirited Away", Rating.PG, 125);
        Movie movie5 = new Movie("Booksmart", Rating.FIFTEEN, 102);

        movieService.logMovie(movie1);
        movieService.logMovie(movie2);
        movieService.logMovie(movie3);
        movieService.logMovie(movie4);
        movieService.logMovie(movie5);

    }
}

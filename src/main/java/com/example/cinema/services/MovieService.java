package com.example.cinema.services;

import com.example.cinema.models.Movie;

import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService() {
    }

    public void logMovie(Movie movie){
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void updateMovie(Movie loggedMovie, Movie updatedMovie) {

        loggedMovie.setTitle(updatedMovie.getTitle());
        loggedMovie.setRating(updatedMovie.getRating());
        loggedMovie.setDuration(updatedMovie.getDuration());

        movieRepository.save(loggedMovie);
    }

    public void deleteMovie(Movie movieToDelete) {
        movieRepository.delete(movieToDelete);
    }

}

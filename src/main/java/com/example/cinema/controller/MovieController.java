package com.example.cinema.controller;

import com.example.cinema.models.Movie;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(defaultValue = "0") int maxDuration) {
        if (maxDuration < 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        List<Movie> movies = movieService.getMovies(maxDuration);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMovies(@RequestBody ArrayList<Movie> movies) {

        for (Movie movie : movies) {
            movieService.logMovie(movie);
        }

        return new ResponseEntity<>("Movie(s) added successfully!", HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable long id, @RequestBody Movie updatedMovie) {
        if(movieService.getMovieById(id).isEmpty()) {
            return new ResponseEntity<>("ID not found", HttpStatus.BAD_REQUEST);
        }
        movieService.updateMovie(movieService.getMovieById(id).get(), updatedMovie);
        return new ResponseEntity<>(updatedMovie.getTitle() + " updated successfully!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id) {
        Optional<Movie> movieToDelete = movieService.getMovieById(id);
        if(movieToDelete.isEmpty()) {
            return new ResponseEntity<>("ID not found", HttpStatus.BAD_REQUEST);
        }
        movieService.deleteMovie(movieToDelete.get());
        return new ResponseEntity<>(movieToDelete.get().getTitle() + " deleted successfully!", HttpStatus.OK);
    }

}

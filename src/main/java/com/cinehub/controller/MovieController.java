package com.cinehub.controller;

import com.cinehub.model.Movie;
import com.cinehub.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/count")
    public long getMovieCount() {
        return movieService.getMovieCount();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return movie;
    }
}

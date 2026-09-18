package com.cinehub.service;

import com.cinehub.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return List.copyOf(movies);
    }

    public List<Movie> getMoviesAfterYear(int year) {
        return movies.stream()
                .filter(movie -> movie.getYear() > year)
                .toList();
    }

    public List<Movie> searchByTitle(String title) {
        return movies.stream()
                .filter(movie ->
                        movie.getTitle()
                                .toLowerCase()
                                .contains(title.toLowerCase())
                )
                .toList();
    }

    public Optional<Movie> findByTitle(String title) {
        return movies.stream()
                .filter(movie ->
                        movie.getTitle().equalsIgnoreCase(title)
                )
                .findFirst();
    }

    public List<Movie> getMoviesByYear(int year) {
        return movies.stream()
                .filter(movie -> movie.getYear() == year)
                .toList();
    }

    public int getMovieCount() {
        return movies.size();
    }
}

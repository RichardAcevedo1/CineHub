package com.cinehub.service;

import com.cinehub.model.Genre;
import com.cinehub.model.Movie;
import com.cinehub.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public long getMovieCount() {
        return movieRepository.count();
    }

    public List<Movie> getMoviesAfterYear(int year) {
        return movieRepository.findByYearGreaterThan(year);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitleIgnoreCase(title);
    }

    public List<Movie> getMoviesByYear(int year) {
        return movieRepository.findByYear(year);
    }

    public List<Movie> getMoviesByGenre(Genre genre) {
        return movieRepository.findByGenre(genre);
    }

}

package com.cinehub.service;

import com.cinehub.model.Movie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieServiceTest {

    @Test
    void shouldAddMovie() {

        MovieService movieService = new MovieService();

        Movie movie = new Movie("The Matrix", 1999);

        movieService.addMovie(movie);

        assertEquals(1, movieService.getAllMovies().size());
    }

    @Test
    void shouldReturnAllMovies() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Alien", 1979)
        );

        var movies = movieService.getAllMovies();

        assertEquals(2, movies.size());
        assertEquals("The Matrix", movies.get(0).getTitle());
        assertEquals("Alien", movies.get(1).getTitle());
    }

    @Test
    void shouldFindMoviesByYear() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Inception", 2010)
        );

        movieService.addMovie(
                new Movie("Interstellar", 2014)
        );

        var movies = movieService.getMoviesByYear(2010);

        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
    }

    @Test
    void shouldSearchMoviesByTitle() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Inception", 2010)
        );

        var movies = movieService.searchByTitle("THE");

        assertEquals(1, movies.size());
        assertEquals("The Matrix", movies.get(0).getTitle());
    }

    @Test
    void shouldFindByTitle() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Inception", 2010)
        );

        var movie = movieService.findByTitle("Inception");

        assertTrue(movie.isPresent());
        assertEquals("Inception", movie.get().getTitle());
    }

    @Test
    void shouldReturnEmptyWhenMovieDoesNotExist() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        var movie = movieService.findByTitle("Inception");

        assertTrue(movie.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenNoMoviesMatchYear() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Alien", 1979)
        );

        var movies = movieService.getMoviesByYear(2020);

        assertTrue(movies.isEmpty());
    }

    @Test
    void shouldAddMultipleMovies() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Alien", 1979)
        );

        movieService.addMovie(
                new Movie("Inception", 2010)
        );

        movieService.addMovie(
                new Movie("Interstellar", 2014)
        );

        var movies = movieService.getAllMovies();

        assertEquals(4, movies.size());
        assertEquals("The Matrix", movies.getFirst().getTitle());
        assertEquals("Interstellar", movies.getLast().getTitle());
    }

    @Test
    void shouldReturnEmptyListWhenSearchByXyz() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Alien", 1979)
        );

        var movies = movieService.searchByTitle("xyz");

        assertTrue(movies.isEmpty());
    }
}

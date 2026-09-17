package com.cinehub.service;

import com.cinehub.model.Genre;
import com.cinehub.model.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieServiceTest {

    @Test
    void shouldAddMovie() {

        MovieService movieService = new MovieService();

        Movie movie = new Movie(1L, "The Matrix", 1999, Genre.SCI_FI);

        movieService.addMovie(movie);

        assertEquals(1, movieService.getAllMovies().size());
    }

    @Test
    void shouldReturnAllMovies() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(2L, "Alien", 1979, Genre.HORROR)
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
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(3L, "Inception", 2010, Genre.DRAMA)
        );

        movieService.addMovie(
                new Movie(4L, "Interstellar", 2014, Genre.SCI_FI)
        );

        var movies = movieService.getMoviesByYear(2010);

        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
    }

    @Test
    void shouldSearchMoviesByTitle() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(3L, "Inception", 2010, Genre.DRAMA)
        );

        var movies = movieService.searchByTitle("THE");

        assertEquals(1, movies.size());
        assertEquals("The Matrix", movies.get(0).getTitle());
    }

    @Test
    void shouldFindByTitle() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(3L, "Inception", 2010, Genre.DRAMA)
        );

        var movie = movieService.findByTitle("Inception");

        assertTrue(movie.isPresent());
        assertEquals("Inception", movie.get().getTitle());
    }

    @Test
    void shouldReturnEmptyWhenMovieDoesNotExist() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        var movie = movieService.findByTitle("Inception");

        assertTrue(movie.isEmpty());
    }

    @Test
    void shouldReturnEmptyListWhenNoMoviesMatchYear() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(2L, "Alien", 1979, Genre.HORROR)
        );

        var movies = movieService.getMoviesByYear(2020);

        assertTrue(movies.isEmpty());
    }

    @Test
    void shouldAddMultipleMovies() {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(2L, "Alien", 1979, Genre.HORROR)
        );

        movieService.addMovie(
                new Movie(3L, "Inception", 2010, Genre.DRAMA)
        );

        movieService.addMovie(
                new Movie(4L, "Interstellar", 2014, Genre.SCI_FI)
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
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(2L, "Alien", 1979, Genre.HORROR)
        );

        var movies = movieService.searchByTitle("xyz");

        assertTrue(movies.isEmpty());
    }

    @Test
    void shouldNotAllowExternalModificationOfMovies() {
        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        List<Movie> movies = movieService.getAllMovies();

        assertThrows(
                UnsupportedOperationException.class,
                () -> movies.clear()
        );

    }
}

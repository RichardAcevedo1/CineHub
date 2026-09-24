package com.cinehub.repository;

import com.cinehub.model.Genre;
import com.cinehub.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void shouldSaveAndFindMovie() {

        Movie movie = new Movie(
                "The Matrix",
                1999,
                Genre.SCI_FI
        );

        Movie savedMovie = movieRepository.save(movie);

        assertNotNull(savedMovie.getId());

        var foundMovie =
                movieRepository.findById(savedMovie.getId());

        assertTrue(foundMovie.isPresent());
        assertEquals(
                "The Matrix",
                foundMovie.get().getTitle()
        );
    }

    @Test
    void shouldFindMoviesAfterYear() {

        movieRepository.save(
                new Movie("Alien", 1979, Genre.HORROR)
        );

        movieRepository.save(
                new Movie("The Matrix", 1999, Genre.SCI_FI)
        );

        movieRepository.save(
                new Movie("Inception", 2010, Genre.THRILLER)
        );

        List<Movie> movies = movieRepository.findByYearGreaterThan(2000);

        assertEquals(1, movies.size());
        assertEquals("Inception", movies.get(0).getTitle());
    }

    @Test
    void shouldSearchMoviesByTitleIgnoringCase() {

        movieRepository.save(
                new Movie("The Matrix", 1999, Genre.SCI_FI)
        );

        List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase("matrix");

        assertEquals(1, movies.size());
        assertEquals("The Matrix", movies.get(0).getTitle());
    }

    @Test
    void shouldFindMovieByExactTitleIgnoringCase() {

        movieRepository.save(
                new Movie("Alien", 1979, Genre.HORROR)
        );

        Optional<Movie> movie = movieRepository.findByTitleIgnoreCase("alien");

        assertTrue(movie.isPresent());
        assertEquals("Alien", movie.get().getTitle());
    }

    @Test
    void shouldFindMoviesByYear() {

        movieRepository.save(
                new Movie("Movie A", 2000, Genre.DRAMA)
        );

        movieRepository.save(
                new Movie("Movie B", 2000, Genre.ACTION)
        );

        movieRepository.save(
                new Movie("Movie C", 2010, Genre.HORROR)
        );

        List<Movie> movies = movieRepository.findByYear(2000);

        assertEquals(2, movies.size());
    }

    @Test
    void shouldFindMoviesByGenre() {

        movieRepository.save(
                new Movie("Movie A", 2000, Genre.DRAMA)
        );

        List<Movie> movies = movieRepository.findByGenre(Genre.DRAMA);

        assertEquals(1, movies.size());
        assertEquals("Movie A", movies.get(0).getTitle());
    }
}

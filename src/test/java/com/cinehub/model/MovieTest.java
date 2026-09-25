package com.cinehub.model;

import com.cinehub.exception.InvalidMovieException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    void shouldCreateValidMovie() {

        Movie movie = new Movie("The Matrix", 1999, Genre.SCI_FI);

        assertEquals("The Matrix", movie.getTitle());
        assertEquals(1999, movie.getYear());
    }

    @Test
    void shouldAcceptMovieFrom1888() {

        Movie movie = new Movie("A trip to the Moon", 1888, Genre.DRAMA);

        assertEquals(1888, movie.getYear());
    }

    @Test
    void shouldRejectEmptyTitle() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("", 1999, Genre.ACTION)
        );
    }

    @Test
    void shouldRejectTitleWithOneCharacter() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("A", 1999, Genre.COMEDY)
        );
    }

    @Test
    void shouldRejectYearBefore1888() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("The Matrix", 1800, Genre.SCI_FI)
        );
    }

    @Test
    void shouldRejectFutureYear() {

        int futureYear = LocalDate.now().getYear() + 1;

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("The Matrix", futureYear, Genre.SCI_FI)
        );
    }

    @Test
    void shouldRejectBlankTitle() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("  ", 1999, Genre.ACTION)
        );
    }

//    @Test
//    void shouldConsiderMoviesWithSameIdEqual() {
//        Movie movie1 = new Movie(
//                "The Matrix",
//                1999,
//                Genre.SCI_FI
//        );
//
//        Movie movie2 = new Movie(
//                "The Matrix",
//                1999,
//                Genre.SCI_FI
//        );
//
//        assertEquals(movie1, movie2);
//    }
//
//    @Test
//    void shouldConsiderMoviesWithDifferentIdsNotEqual() {
//        Movie movie1 = new Movie(
//               "The Matrix",
//                1999,
//                Genre.SCI_FI
//        );
//
//        Movie movie2 = new Movie(
//                "The Matrix",
//                1999,
//                Genre.SCI_FI
//        );
//
//        assertNotEquals(movie1, movie2);
//    }

    @Test
    void shouldReturnCorrectMovieInformation() {
        Movie movie = new Movie(
                "Alien",
                1979,
                Genre.HORROR
        );

        assertEquals("Alien", movie.getTitle());
        assertEquals(1979, movie.getYear());
        assertEquals(Genre.HORROR, movie.getGenre());
    }
}

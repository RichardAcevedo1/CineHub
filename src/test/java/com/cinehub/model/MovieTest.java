package com.cinehub.model;

import com.cinehub.exception.InvalidMovieException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieTest {

    @Test
    void shouldCreateValidMovie() {

        Movie movie = new Movie("The Matrix", 1999);

        assertEquals("The Matrix", movie.getTitle());
        assertEquals(1999, movie.getYear());
    }

    @Test
    void shouldAcceptMovieFrom1888() {

        Movie movie = new Movie("A trip to the Moon", 1888);

        assertEquals(1888, movie.getYear());
    }

    @Test
    void shouldRejectEmptyTitle() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("", 1999)
        );
    }

    @Test
    void shouldRejectTitleWithOneCharacter() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("A", 1999)
        );
    }

    @Test
    void shouldRejectYearBefore1888() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("The Matrix", 1800)
        );
    }

    @Test
    void shouldRejectFutureYear() {

        int futureYear = LocalDate.now().getYear() + 1;

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("The Matrix", futureYear)
        );
    }

    @Test
    void shouldRejectBlankTitle() {

        assertThrows(
                InvalidMovieException.class,
                () -> new Movie("  ", 1999)
        );
    }
}

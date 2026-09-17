package com.cinehub.controller;

import com.cinehub.service.MovieService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieControllerTest {

    @Test
    void shouldCreateMovieController() {

        MovieService movieService = new MovieService();

        MovieController movieController = new MovieController(movieService);

        assertNotNull(movieController);
    }
}

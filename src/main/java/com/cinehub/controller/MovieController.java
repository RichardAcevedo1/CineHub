package com.cinehub.controller;

import com.cinehub.service.MovieService;

public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
}

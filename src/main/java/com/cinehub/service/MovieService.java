package com.cinehub.service;

import com.cinehub.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}

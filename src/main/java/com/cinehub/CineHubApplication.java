package com.cinehub;

import com.cinehub.model.Movie;
import com.cinehub.service.MovieService;

public class CineHubApplication {

    public static void main(String[] args) {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie("The Matrix", 1999)
        );

        movieService.addMovie(
                new Movie("Alien", 1979)
        );

        movieService.addMovie(
                new Movie("Interstellar", 2014)
        );

        for(Movie movie : movieService.getAllMovies()) {
            System.out.println(
                    movie.getTitle() + " - " + movie.getYear()
            );
        }
    }
}

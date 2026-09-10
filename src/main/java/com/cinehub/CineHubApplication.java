package com.cinehub;

import com.cinehub.model.Movie;
import com.cinehub.service.MovieService;

import java.util.List;
import java.util.Optional;

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

        movieService.addMovie(
                new Movie("Inception", 2010)
        );

        movieService.addMovie(
                new Movie("Dune", 2021)
        );

        for(Movie movie : movieService.getAllMovies()) {
            System.out.println(
                    movie.getTitle() + " - " + movie.getYear()
            );
        }

        List<Movie> moviesAfter = movieService.getMoviesAfterYear(2000);
        System.out.println("\nPeliculas después del 2000");
        for(Movie movie : moviesAfter) {
            System.out.println(movie.getTitle());
        }

        Optional<Movie> movie = movieService.findByTitle("Alien");

        if(movie.isPresent()) {
            System.out.println(
                    "\nEncontrada: " + movie.get().getTitle()
            );
        } else {
            System.out.println("\nPelicula no encontrada");
        }

        Optional<Movie> movie2 = movieService.findByTitle("Avatar");

        if(movie2.isPresent()) {
            System.out.println(
                    "\nEncontrada: " + movie2.get().getTitle()
            );
        } else {
            System.out.println("\nPelicula no encontrada");
        }

        System.out.println("\n=============================");
        System.out.println("Movies By Year");
        List<Movie> moviesByYear = movieService.getMoviesByYear(1999);

        for(Movie movieByYear : moviesByYear) {
            System.out.println(movieByYear.getTitle());
        }
    }
}

package com.cinehub;

import com.cinehub.exception.InvalidMovieException;
import com.cinehub.model.Genre;
import com.cinehub.model.Movie;
import com.cinehub.service.MovieService;

import java.util.List;
import java.util.Optional;

public class CineHubApplication {

    public static void main(String[] args) {

        MovieService movieService = new MovieService();

        movieService.addMovie(
                new Movie(1L, "The Matrix", 1999, Genre.SCI_FI)
        );

        movieService.addMovie(
                new Movie(2L, "Alien", 1989, Genre.HORROR)
        );

        movieService.addMovie(
                new Movie(3L, "Interstellar", 2014, Genre.SCI_FI)
        );

//        try {
//            Movie movie = new Movie("A", 1999);
//            System.out.println("Película creada");
//        } catch(InvalidMovieException ime) {
//            System.out.println(
//                    "Error al crear la pelicula: " + ime.getMessage()
//            );
//        }

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

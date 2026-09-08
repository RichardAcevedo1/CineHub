package com.cinehub;

import com.cinehub.model.Movie;

public class CineHubApplication {

    public static void main(String[] args) {
        Movie movie = new Movie("The Matrix", 1999);

        System.out.println("Pelicula: " + movie.getTitle());
        System.out.println("Año: " + movie.getYear());
    }
}

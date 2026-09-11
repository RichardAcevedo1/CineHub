package com.cinehub.model;

import com.cinehub.exception.InvalidMovieException;

import java.time.LocalDate;

public class Movie {
    private String title;
    private int year;

    public Movie(String title, int year) {

        if(title == null || title.isBlank()) {
            throw new InvalidMovieException("El titulo no puede estar vacío");
        }

        if(title.length() < 2) {
            throw new InvalidMovieException(
                    "El título debe tener al menos 2 caracteres"
            );
        }

        if(year < 1888 || year > LocalDate.now().getYear()) {
            throw new InvalidMovieException("El año no es válido");
        }

        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}



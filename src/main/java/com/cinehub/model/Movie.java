package com.cinehub.model;

import com.cinehub.exception.InvalidMovieException;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int year;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    protected Movie(){}

    public Movie(String title, int year, Genre genre) {

        this.title = title;
        this.year = year;
        this.genre = genre;

        validate();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title=" + title + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof Movie movie)) {
            return false;
        }

        return id != null && id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void validate() {

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
    }
}



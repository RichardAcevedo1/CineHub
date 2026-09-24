package com.cinehub.repository;

import com.cinehub.model.Genre;
import com.cinehub.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByYearGreaterThan(int year);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    Optional<Movie> findByTitleIgnoreCase(String title);

    List<Movie> findByYear(int year);

    List<Movie> findByGenre(Genre genre);
}

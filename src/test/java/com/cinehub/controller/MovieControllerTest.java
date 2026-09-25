package com.cinehub.controller;

import com.cinehub.exception.InvalidMovieException;
import com.cinehub.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService movieService;

    @Test
    void shouldReturnBadRequestWhenMovieIsInvalid()
            throws Exception {

        when(movieService.addMovie(org.mockito.ArgumentMatchers.any()))
                .thenThrow(
                        new InvalidMovieException(
                                "El título no puede estar vacío"
                        )
                );

        mockMvc.perform(
                        post("/movies")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                {
                                    "title": "",
                                    "year": 2020,
                                    "genre": "DRAMA"
                                }
                                """)
                )
                .andExpect(status().isBadRequest())
                .andExpect(
                        content().json("""
                        {
                            "error": "El título no puede estar vacío"
                        }
                """)
                );
    }
}
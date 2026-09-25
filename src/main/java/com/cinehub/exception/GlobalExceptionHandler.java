package com.cinehub.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidMovieException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMovie(
            InvalidMovieException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(exception.getMessage());

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }
}

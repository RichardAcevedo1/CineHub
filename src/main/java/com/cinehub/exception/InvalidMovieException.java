package com.cinehub.exception;

public class InvalidMovieException extends RuntimeException{

    public InvalidMovieException(String message) {
        super(message);
    }
}

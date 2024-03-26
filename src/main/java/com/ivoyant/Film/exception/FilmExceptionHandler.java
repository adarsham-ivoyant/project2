package com.ivoyant.Film.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FilmExceptionHandler {
    @ExceptionHandler(value = {FilmNotFoundException.class})
    public ResponseEntity<Object> handleFilmNotFoundException
            (FilmNotFoundException filmNotFoundException)
    {
        FilmException filmException= new FilmException(
                filmNotFoundException.getMessage(),
                filmNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(filmException,HttpStatus.NOT_FOUND);
    }
}

package com.ilbeol.staff.infraestructure.exception;

import com.ilbeol.staff.application.exception.InvalidPlaylistException;
import com.ilbeol.staff.domain.exception.PlaylistNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlaylistNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePlaylistNotFound(PlaylistNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidPlaylistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidPlaylist(InvalidPlaylistException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}

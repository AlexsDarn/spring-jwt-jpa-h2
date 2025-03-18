package com.ilbeol.staff.domain.exception;

public class PlaylistNotFoundException extends RuntimeException {
    public PlaylistNotFoundException(String message) {
        super(message);
    }
}

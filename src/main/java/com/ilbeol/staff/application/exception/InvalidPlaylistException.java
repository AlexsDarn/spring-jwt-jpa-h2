package com.ilbeol.staff.application.exception;

public class InvalidPlaylistException extends RuntimeException {
    public InvalidPlaylistException(String message) {
        super(message);
    }
}

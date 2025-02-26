package com.souza.charles.triathlete_sponsorship_web.exceptions;

public class TriathleteNotFoundException extends RuntimeException {
    public TriathleteNotFoundException(Object id) {
        super("Triathlete with id: " + id + " does not exist");
    }
}

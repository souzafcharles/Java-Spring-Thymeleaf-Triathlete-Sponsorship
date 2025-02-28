package com.souza.charles.triathlete_sponsorship_web.exceptions;

public class SponsorAlreadyExistsException extends RuntimeException {
    public SponsorAlreadyExistsException(String title) {
        super("Sponsor with title: " + title + " already exists");
    }
}
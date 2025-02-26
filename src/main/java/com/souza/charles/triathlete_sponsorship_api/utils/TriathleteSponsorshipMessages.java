package com.souza.charles.triathlete_sponsorship_api.utils;

public class TriathleteSponsorshipMessages {

    private TriathleteSponsorshipMessages() {
        throw new IllegalStateException("Utility class");
    }

    // Triathlete Messages
    public static final String TRIATHLETE_NAME_REQUIRED = "Name is required";
    public static final String TRIATHLETE_NAME_MIN_LENGTH = "Name must have at least 2 characters";
    public static final String TRIATHLETE_AGE_MIN = "Triathletes must be 18 years of age or older";
    public static final String TRIATHLETE_SAVED_SUCCESSFULLY = "Triathlete saved successfully!";

    // Sponsor Messages
    public static final String SPONSOR_TITLE_REQUIRED = "Title is required";
    public static final String SPONSOR_TITLE_MIN_LENGTH = "Title must have at least 2 characters";
}
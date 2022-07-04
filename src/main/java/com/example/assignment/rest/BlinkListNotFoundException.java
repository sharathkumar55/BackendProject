package com.example.assignment.rest;

public class BlinkListNotFoundException extends  RuntimeException{
    public BlinkListNotFoundException(String message) {
        super(message);
    }

    public BlinkListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlinkListNotFoundException(Throwable cause) {
        super(cause);
    }
}

package com.example.springServerDemo;

public class CompetitorNotFoundException extends RuntimeException {

    public CompetitorNotFoundException() {
        super();

    }

    public CompetitorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public CompetitorNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }

    public CompetitorNotFoundException(String message) {
        super(message);

    }

    public CompetitorNotFoundException(Throwable cause) {
        super(cause);
    }
}

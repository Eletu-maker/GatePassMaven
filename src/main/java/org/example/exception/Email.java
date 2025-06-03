package org.example.exception;

public class Email extends RuntimeException {
    public Email(String message) {
        super(message);
    }
}

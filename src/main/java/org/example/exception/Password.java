package org.example.exception;

public class Password extends RuntimeException {
    public Password(String message) {
        super(message);
    }
}

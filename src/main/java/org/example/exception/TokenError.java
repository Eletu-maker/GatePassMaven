package org.example.exception;

public class TokenError extends RuntimeException {
    public TokenError(String message) {
        super(message);
    }
}

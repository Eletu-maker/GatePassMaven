package org.example.exception;

public class TokenUsed extends RuntimeException {
    public TokenUsed(String message) {
        super(message);
    }
}

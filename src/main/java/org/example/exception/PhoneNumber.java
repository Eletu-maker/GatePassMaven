package org.example.exception;

public class PhoneNumber extends RuntimeException {
    public PhoneNumber(String message) {
        super(message);
    }
}

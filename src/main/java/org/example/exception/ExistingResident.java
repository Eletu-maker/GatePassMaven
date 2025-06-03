package org.example.exception;

public class ExistingResident extends RuntimeException {
    public ExistingResident(String message) {
        super(message);
    }
}

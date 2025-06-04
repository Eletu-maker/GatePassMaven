package org.example.exception;

public class ExistingSecurity extends RuntimeException {
  public ExistingSecurity(String message) {
    super(message);
  }
}

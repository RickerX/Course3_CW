package com.example.course3_cw.exception;

public class InSufficientProductQuantityException extends RuntimeException {
    public InSufficientProductQuantityException(String message) {
        super(message);
    }
}

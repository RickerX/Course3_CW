package com.example.course3_cw.exception;

public class InvalidProductRequestException extends RuntimeException{
    public InvalidProductRequestException(String message) {
        super(message);
    }
}

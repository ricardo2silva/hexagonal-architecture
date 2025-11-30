package com.ricardo.hexagonal_architecture.application.core.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}

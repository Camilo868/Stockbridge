package com.stockbridge.inventory.domain.exception;

public class InvalidMovementException extends RuntimeException {
    public InvalidMovementException(String message) {
        super(message);
    }
}

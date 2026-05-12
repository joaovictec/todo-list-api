package com.example.taskmanager.exception;

/**
 * Custom exception to indicate that a resource was not found.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.example.taskmanager.exception;

/**
 * Standardized error response DTO for API error responses.
 */
public class ErrorResponseDTO {

    private String error;
    private String message;
    private int status;
    private String timestamp;

    public ErrorResponseDTO() {
    }

    public ErrorResponseDTO(String error, String message, int status, String timestamp) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
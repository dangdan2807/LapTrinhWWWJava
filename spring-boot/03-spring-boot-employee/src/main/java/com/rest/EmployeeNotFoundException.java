package com.rest;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

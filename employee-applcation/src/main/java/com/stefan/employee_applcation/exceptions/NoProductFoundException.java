package com.stefan.employee_applcation.exceptions;

public class NoProductFoundException extends RuntimeException {

    public NoProductFoundException(String message) {
        super(message);
    }
}

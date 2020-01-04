package com.insurance.crm.exception;

public class NotDeletedException extends RuntimeException {
    public NotDeletedException(String message) {
        super(message);
    }
}

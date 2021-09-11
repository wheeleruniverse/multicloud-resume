package com.wheeler.core.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(String.format("BadRequestException: %s", message));
    }
}

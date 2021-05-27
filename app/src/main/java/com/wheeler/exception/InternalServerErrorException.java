package com.wheeler.exception;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message){
        super(String.format("InternalServerErrorException: %s", message));
    }
}

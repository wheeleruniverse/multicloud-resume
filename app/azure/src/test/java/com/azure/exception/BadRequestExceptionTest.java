package com.azure.exception;

import com.wheeler.core.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadRequestExceptionTest {

    @Test
    public void newBadRequestException(){
        BadRequestException e = new BadRequestException("My Message");
        Assertions.assertEquals("BadRequestException: My Message", e.getMessage());
    }

    @Test
    public void newBadRequestExceptionWithNull(){
        BadRequestException e = new BadRequestException(null);
        Assertions.assertEquals("BadRequestException: null", e.getMessage());
    }
}

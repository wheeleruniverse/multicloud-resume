package com.wheeler.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadRequestExceptionTest {

    @Test
    public void newBadRequestException(){
        BadRequestException e = new BadRequestException("My Message");
        Assertions.assertEquals("BadRequestException: My Message", e.getMessage());
    }
}

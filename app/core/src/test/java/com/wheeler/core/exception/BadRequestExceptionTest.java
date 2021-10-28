package com.wheeler.core.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadRequestExceptionTest {

    @Test
    public void construct(){
        BadRequestException e = new BadRequestException("My Message");
        Assertions.assertEquals("BadRequestException: My Message", e.getMessage());
    }

    @Test
    public void constructWithNull(){
        BadRequestException e = new BadRequestException(null);
        Assertions.assertEquals("BadRequestException: null", e.getMessage());
    }
}

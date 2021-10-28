package com.wheeler.core.dto.model.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArgumentTest {

    @Test
    public void construct(){
        final Argument<String> arg = new Argument<>("arg0", "val0");
        Assertions.assertEquals("arg0", arg.getName());
        Assertions.assertEquals("val0", arg.getValue());
    }
}

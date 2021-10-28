package com.wheeler.core.dto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldDtoTest {

    @Test
    public void construct(){
        final FieldDto field = new FieldDto("name", String.class, "value");
        Assertions.assertEquals("name", field.getName());
        Assertions.assertEquals(String.class, field.getType());
        Assertions.assertEquals("value", field.getValue());
    }
}

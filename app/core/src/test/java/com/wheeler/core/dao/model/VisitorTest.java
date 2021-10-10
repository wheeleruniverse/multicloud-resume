package com.wheeler.core.dao.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest {

    @Test
    public void getTableName(){
        final String expected = Visitor.class.getSimpleName().toLowerCase();
        assertEquals(expected, Visitor.getTableName());
    }
}

package com.wheeler.core.dao.model.partial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonthYearTest {

    @Test
    public void construct(){
        final MonthYear instance = getInstance();
        Assertions.assertEquals(1, instance.getMonth());
        Assertions.assertEquals(2021, instance.getYear());
    }

    public static MonthYear getInstance(){
        return new MonthYear(1, 2021);
    }
}

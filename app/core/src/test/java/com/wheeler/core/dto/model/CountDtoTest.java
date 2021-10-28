package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.CountTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountDtoTest {

    @Test
    public void construct(){
        final CountDto instance = getInstance();
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals(1, instance.getValue());
    }

    @Test
    public void constructWithCount(){
        final CountDto instance = new CountDto(CountTest.getInstance());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals(1, instance.getValue());
    }

    public static CountDto getInstance(){
        final CountDto instance = new CountDto();
        instance.setName("name");
        instance.setValue(1);
        return instance;
    }
}

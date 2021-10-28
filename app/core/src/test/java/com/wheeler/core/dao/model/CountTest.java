package com.wheeler.core.dao.model;

import com.wheeler.core.utility.RandomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountTest {

    private static final String ID = "count";
    private Count instance;

    @BeforeEach
    public void beforeEach() {
        this.instance = getInstance();
    }

    @Test
    public void construct(){
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals(1, instance.getValue());
    }

    @Test
    public void getId(){
        assertEquals(ID, instance.getId());
    }

    @Test
    public void setId(){
        instance.setId(RandomUtil.getString());
        assertEquals(ID, instance.getId());
    }

    @Test
    public void getVal(){
        final int value = RandomUtil.getInt();
        instance.setValue(value);
        assertEquals(value, instance.getVal());
    }

    @Test
    public void setVal(){
        final int value = RandomUtil.getInt();
        instance.setVal(value);
        assertEquals(value, instance.getValue());
    }

    @Test
    public void increment(){
        instance.increment();
        assertEquals(2, instance.getValue());
    }

    @Test
    public void incrementNegative(){
        instance.setVal(-9);
        instance.increment();
        assertEquals(1, instance.getValue());
    }

    @Test
    public void incrementNull(){
        instance.setValue(null);
        instance.increment();
        assertEquals(1, instance.getValue());
    }

    public static Count getInstance(){
        final Count instance = new Count();
        instance.setName("name");
        instance.setValue(1);
        return instance;
    }
}

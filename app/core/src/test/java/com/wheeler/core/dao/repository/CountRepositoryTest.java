package com.wheeler.core.dao.repository;

import com.wheeler.core.dao.model.Count;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountRepositoryTest {

    private Count instance;

    @BeforeEach
    public void beforeEach(){
        this.instance = new Count("CountRepositoryTest", 0);
    }

    @Test
    public void count(){
        final CountRepository repository = getRepository();
        assertEquals(repository.count(), instance);
    }

    @Test
    public void increment(){
        final CountRepository repository = getRepository();
        repository.increment();
        assertEquals(1, instance.getValue());
    }

    @Test
    public void load(){
        final CountRepository repository = getRepository();
        final int value = 9;
        repository.load(value);
        assertEquals(value, instance.getValue());
    }

    private CountRepository getRepository(){
        return new CountRepository() {
            @Override
            public Count count() {
                return instance;
            }
            @Override
            public void increment() {
                instance.increment();
            }
            @Override
            public void load(Integer value) {
                instance.setValue(value);
            }
        };
    }
}

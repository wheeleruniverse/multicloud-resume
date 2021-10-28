package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.ExperienceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExperienceDtoTest {

    @Test
    public void construct(){
        final ExperienceDto instance = getInstance();
        Assertions.assertEquals(ExperienceTest.getInstanceList(), instance.getData());
    }

    public static ExperienceDto getInstance(){
        return new ExperienceDto(ExperienceTest.getInstanceList());
    }
}

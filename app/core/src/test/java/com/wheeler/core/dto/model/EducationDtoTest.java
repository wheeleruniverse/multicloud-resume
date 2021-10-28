package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.EducationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EducationDtoTest {

    @Test
    public void construct(){
        final EducationDto instance = getInstance();
        Assertions.assertEquals(EducationTest.getInstanceList(), instance.getData());
    }

    public static EducationDto getInstance(){
        return new EducationDto(EducationTest.getInstanceList());
    }
}

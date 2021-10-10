package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EducationTest extends ModelImplTest<Education> {

    @Override
    public Class<Education> getDaoClass() {
        return Education.class;
    }

    @Test
    public void getTableName(){
        final String expected = Education.class.getSimpleName().toLowerCase();
        assertEquals(expected, Education.getTableName());
    }
}

package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExperienceTest extends ModelImplTest<Experience> {

    @Override
    public Class<Experience> getDaoClass() {
        return Experience.class;
    }

    @Test
    public void getTableName(){
        final String expected = Experience.class.getSimpleName().toLowerCase();
        assertEquals(expected, Experience.getTableName());
    }
}

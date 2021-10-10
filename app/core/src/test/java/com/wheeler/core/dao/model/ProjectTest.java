package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest extends ModelImplTest<Project> {

    @Override
    public Class<Project> getDaoClass() {
        return Project.class;
    }

    @Test
    public void getTableName(){
        final String expected = Project.class.getSimpleName().toLowerCase();
        assertEquals(expected, Project.getTableName());
    }
}

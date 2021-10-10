package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest extends ModelImplTest<Skill> {

    @Override
    public Class<Skill> getDaoClass() {
        return Skill.class;
    }

    @Test
    public void getTableName(){
        final String expected = Skill.class.getSimpleName().toLowerCase();
        assertEquals(expected, Skill.getTableName());
    }
}

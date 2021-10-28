package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.SkillLevel;
import com.wheeler.core.dao.model.helper.ModelImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SkillTest extends ModelImplTest<Skill> {

    @Override
    public Class<Skill> getDaoClass() {
        return Skill.class;
    }

    @Test
    public void construct(){
        final Skill instance = getInstance();
        Assertions.assertEquals("id", instance.getId());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals(SkillLevel.COMPETENT, instance.getLevel());
        Assertions.assertEquals(asList("project0", "project1"), instance.getProjects());
        Assertions.assertEquals("type", instance.getType());
    }

    @Test
    public void getTableName(){
        final String expected = Skill.class.getSimpleName().toLowerCase();
        assertEquals(expected, Skill.getTableName());
    }

    public static Skill getInstance(){
        final Skill instance = new Skill();
        instance.setId("id");
        instance.setName("name");
        instance.setLevel(SkillLevel.COMPETENT);
        instance.setProjects(Arrays.asList("project0", "project1"));
        instance.setType("type");
        return instance;
    }

    public static List<Skill> getInstanceList(){
        return singletonList(getInstance());
    }
}

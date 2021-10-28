package com.wheeler.core.dao.model;

import com.wheeler.core.dao.model.helper.ModelImplTest;
import com.wheeler.core.dao.model.partial.MonthYear;
import com.wheeler.core.dao.model.partial.MonthYearTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectTest extends ModelImplTest<Project> {

    @Override
    public Class<Project> getDaoClass() {
        return Project.class;
    }

    @Test
    public void construct(){
        final Project instance = getInstance();
        Assertions.assertEquals("id", instance.getId());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals("blog", instance.getBlog());
        Assertions.assertEquals("code", instance.getCode());
        Assertions.assertEquals("description", instance.getDescription());
        Assertions.assertEquals(1, instance.getDiagrams());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getEnd());
        Assertions.assertEquals(asList("skill0", "skill1"), instance.getSkills());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getStart());
        Assertions.assertEquals("website", instance.getWebsite());
    }

    @Test
    public void getTableName(){
        final String expected = Project.class.getSimpleName().toLowerCase();
        assertEquals(expected, Project.getTableName());
    }

    public static Project getInstance(){
        final Project instance = new Project();
        instance.setId("id");
        instance.setName("name");
        instance.setBlog("blog");
        instance.setCode("code");
        instance.setDescription("description");
        instance.setDiagrams(1);
        instance.setEnd(MonthYearTest.getInstance());
        instance.setSkills(Arrays.asList("skill0", "skill1"));
        instance.setStart(MonthYearTest.getInstance());
        instance.setWebsite("website");
        return instance;
    }

    public static List<Project> getInstanceList(){
        return singletonList(getInstance());
    }
}

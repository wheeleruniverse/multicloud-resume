package com.wheeler.core.dao.model;

import com.wheeler.core.dao.constant.ExperienceType;
import com.wheeler.core.dao.model.helper.ModelImplTest;
import com.wheeler.core.dao.model.partial.LocationTest;
import com.wheeler.core.dao.model.partial.MonthYearTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExperienceTest extends ModelImplTest<Experience> {

    @Override
    public Class<Experience> getDaoClass() {
        return Experience.class;
    }

    @Test
    public void construct(){
        final Experience instance = getInstance();
        Assertions.assertEquals("id", instance.getId());
        Assertions.assertEquals("name", instance.getName());
        Assertions.assertEquals(asList("description0", "description1"), instance.getDescriptions());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getEnd());
        Assertions.assertEquals(LocationTest.getInstance(), instance.getLocation());
        Assertions.assertEquals("project", instance.getProject());
        Assertions.assertEquals("role", instance.getRole());
        Assertions.assertEquals(MonthYearTest.getInstance(), instance.getStart());
        Assertions.assertEquals("title", instance.getTitle());
        Assertions.assertEquals(ExperienceType.CONTRACT, instance.getType());
    }

    @Test
    public void getTableName(){
        final String expected = Experience.class.getSimpleName().toLowerCase();
        assertEquals(expected, Experience.getTableName());
    }

    public static Experience getInstance(){
        final Experience instance = new Experience();
        instance.setId("id");
        instance.setName("name");
        instance.setDescriptions(asList("description0", "description1"));
        instance.setEnd(MonthYearTest.getInstance());
        instance.setLocation(LocationTest.getInstance());
        instance.setProject("project");
        instance.setRole("role");
        instance.setStart(MonthYearTest.getInstance());
        instance.setTitle("title");
        instance.setType(ExperienceType.CONTRACT);
        return instance;
    }

    public static List<Experience> getInstanceList(){
        return singletonList(getInstance());
    }
}

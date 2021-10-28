package com.wheeler.core.dto.model;

import com.wheeler.core.dao.model.ProjectTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectDtoTest {

    @Test
    public void construct(){
        final ProjectDto instance = getInstance();
        Assertions.assertEquals(ProjectTest.getInstanceList(), instance.getData());
    }

    public static ProjectDto getInstance(){
        return new ProjectDto(ProjectTest.getInstanceList());
    }
}

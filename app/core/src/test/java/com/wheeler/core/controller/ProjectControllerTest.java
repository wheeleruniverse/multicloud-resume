package com.wheeler.core.controller;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.model.partial.MonthYear;
import com.wheeler.core.dto.model.ProjectDto;
import com.wheeler.core.service.ProjectService;
import com.wheeler.core.utility.JsonUtil;
import com.wheeler.core.utility.ReflectUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, ProjectController.class));
    }

    @Test
    public void load() throws Exception {
        when(projectService.projectLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/project/load")
                .content(JsonUtil.toString(getDaoRecords()))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void retrieve() throws Exception {
        final List<Project> daoRecords = getDaoRecords();
        when(projectService.projectRetrieve()).thenReturn((optional) -> daoRecords);

        final MockHttpServletResponse response = mockMvc
            .perform(
                get("/project/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse();

        assertEquals(200, response.getStatus());

        final ProjectDto dto = JsonUtil.toObject(response.getContentAsString(), ProjectDto.class);
        assertEquals(daoRecords, dto.getData());
    }

    private List<Project> getDaoRecords(){
        final Project dao = new Project();
        dao.setId("id");
        dao.setName("name");
        dao.setBlog("blog");
        dao.setCode("code");
        dao.setDescription("description");
        dao.setDiagrams(1);
        dao.setEnd(new MonthYear(1, 2022));
        dao.setSkills(Arrays.asList("skill0", "skill1"));
        dao.setStart(new MonthYear(1, 2021));
        dao.setWebsite("website");
        return singletonList(dao);
    }
}

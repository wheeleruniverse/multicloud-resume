package com.wheeler.core.controller;

import com.wheeler.core.dao.constant.ExperienceType;
import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.model.partial.Location;
import com.wheeler.core.dao.model.partial.MonthYear;
import com.wheeler.core.dto.model.ExperienceDto;
import com.wheeler.core.service.ExperienceService;
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

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ExperienceController.class)
public class ExperienceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExperienceService experienceService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, ExperienceController.class));
    }

    @Test
    public void load() throws Exception {
        when(experienceService.experienceLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/experience/load")
                .content(JsonUtil.toString(getDaoRecords()))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void retrieve() throws Exception {
        final List<Experience> daoRecords = getDaoRecords();
        when(experienceService.experienceRetrieve()).thenReturn((optional) -> daoRecords);

        final MockHttpServletResponse response = mockMvc
            .perform(
                get("/experience/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse();

        assertEquals(200, response.getStatus());

        final ExperienceDto dto = JsonUtil.toObject(response.getContentAsString(), ExperienceDto.class);
        assertEquals(daoRecords, dto.getData());
    }

    private List<Experience> getDaoRecords(){
        final Location location = new Location();
        location.setAddress("address");
        location.setCity("city");
        location.setRemote(true);
        location.setState("state");
        location.setZip("zip");

        final Experience dao = new Experience();
        dao.setId("id");
        dao.setName("name");
        dao.setDescriptions(asList("description0", "description1"));
        dao.setEnd(new MonthYear(1, 2022));
        dao.setLocation(location);
        dao.setProject("project");
        dao.setRole("role");
        dao.setStart(new MonthYear(1, 2021));
        dao.setTitle("title");
        dao.setType(ExperienceType.CONTRACT);

        return singletonList(dao);
    }
}

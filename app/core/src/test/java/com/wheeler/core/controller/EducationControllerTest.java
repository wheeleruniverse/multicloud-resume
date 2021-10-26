package com.wheeler.core.controller;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.model.partial.Location;
import com.wheeler.core.dto.model.EducationDto;
import com.wheeler.core.service.EducationService;
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
@WebMvcTest(controllers = EducationController.class)
public class EducationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EducationService educationService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, EducationController.class));
    }

    @Test
    public void load() throws Exception {
        when(educationService.educationLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/education/load")
                .content(JsonUtil.toString(getDaoRecords()))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void retrieve() throws Exception {
        final List<Education> daoRecords = getDaoRecords();
        when(educationService.educationRetrieve()).thenReturn((optional) -> daoRecords);

        final MockHttpServletResponse response = mockMvc
            .perform(
                get("/education/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse();

        assertEquals(200, response.getStatus());

        final EducationDto dto = JsonUtil.toObject(response.getContentAsString(), EducationDto.class);
        assertEquals(daoRecords, dto.getData());
    }

    private List<Education> getDaoRecords(){
        final Location location = new Location();
        location.setAddress("address");
        location.setCity("city");
        location.setRemote(true);
        location.setState("state");
        location.setZip("zip");

        final Education dao = new Education();
        dao.setId("id");
        dao.setName("name");
        dao.setDegree("degree");
        dao.setDescriptions(asList("description0", "description1"));
        dao.setEnd(2022);
        dao.setField("field");
        dao.setLocation(location);
        dao.setStart(2021);

        return singletonList(dao);
    }
}

package com.wheeler.core.controller;

import com.wheeler.core.dao.model.Count;
import com.wheeler.core.dto.model.CountDto;
import com.wheeler.core.service.VisitorService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = VisitorController.class)
public class VisitorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VisitorService visitorService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, VisitorController.class));
    }

    @Test
    public void count() throws Exception {
        final Count dao = new Count("visitor", 9);
        when(visitorService.visitorCount()).thenReturn((optional) -> dao);

        final MockHttpServletResponse response = mockMvc
                .perform(
                    get("/visitor/count")
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn()
                .getResponse();

        assertEquals(200, response.getStatus());

        final CountDto dto = JsonUtil.toObject(response.getContentAsString(), CountDto.class);
        assertEquals(dao.getName(), dto.getName());
        assertEquals(dao.getValue(), dto.getValue());
    }

    @Test
    public void increment() throws Exception {
        when(visitorService.visitorIncrement()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/visitor/increment")
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void load() throws Exception {
        when(visitorService.visitorLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/visitor/load")
                .content(Integer.toString(9))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }
}

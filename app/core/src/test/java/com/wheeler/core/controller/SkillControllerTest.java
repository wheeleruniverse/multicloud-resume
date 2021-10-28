package com.wheeler.core.controller;

import com.wheeler.core.dao.constant.SkillLevel;
import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.model.SkillTest;
import com.wheeler.core.dto.model.SkillDto;
import com.wheeler.core.dto.model.partial.SkillMetaDto;
import com.wheeler.core.service.SkillService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SkillController.class)
public class SkillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkillService skillService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, SkillController.class));
    }

    @Test
    public void load() throws Exception {
        when(skillService.skillLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/skill/load")
                .content(JsonUtil.toString(SkillTest.getInstanceList()))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void retrieve() throws Exception {
        final SkillMetaDto meta = new SkillMetaDto(SkillLevel.dto());
        final List<Skill> daoRecords = SkillTest.getInstanceList();
        when(skillService.skillRetrieve()).thenReturn((optional) -> daoRecords);

        final MockHttpServletResponse response = mockMvc
            .perform(
                get("/skill/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse();

        assertEquals(200, response.getStatus());

        final SkillDto dto = JsonUtil.toObject(response.getContentAsString(), SkillDto.class);
        assertEquals(daoRecords, dto.getData());
        assertEquals(meta, dto.getMeta());
    }
}

package com.wheeler.core.controller;

import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.model.CertificationTest;
import com.wheeler.core.dto.model.CertificationDto;
import com.wheeler.core.dto.model.partial.CertificationMetaDto;
import com.wheeler.core.service.CertificationService;
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
@WebMvcTest(controllers = CertificationController.class)
public class CertificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CertificationService certificationService;

    @Test
    public void annotationController(){
        assertNotNull(ReflectUtil.getAnnotation(Controller.class, CertificationController.class));
    }

    @Test
    public void load() throws Exception {
        when(certificationService.certificationLoad()).thenReturn((str) -> Optional.empty());
        mockMvc
            .perform(
                post("/certification/load")
                .content(JsonUtil.toString(CertificationTest.getInstanceList()))
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(
                status().is(204)
            );
    }

    @Test
    public void retrieve() throws Exception {
        final CertificationMetaDto meta = new CertificationMetaDto(
            CertificationLevel.dto(),
            CertificationVendor.dto()
        );
        final List<Certification> daoRecords = CertificationTest.getInstanceList();
        when(certificationService.certificationRetrieve()).thenReturn((optional) -> daoRecords);

        final MockHttpServletResponse response = mockMvc
            .perform(
                get("/certification/retrieve")
                .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse();

        assertEquals(200, response.getStatus());

        final CertificationDto dto = JsonUtil.toObject(response.getContentAsString(), CertificationDto.class);
        assertEquals(daoRecords, dto.getData());
        assertEquals(meta, dto.getMeta());
    }
}

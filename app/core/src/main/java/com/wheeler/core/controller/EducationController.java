package com.wheeler.core.controller;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dto.model.EducationDto;
import com.wheeler.core.service.EducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/education")
public class EducationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EducationController.class);
    private final EducationService educationService;

    public EducationController(final EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        educationService.educationLoad().apply(json);
        httpResponse.setStatus(204);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public EducationDto retrieve(){
        final List<Education> data = educationService.educationRetrieve().apply(Optional.empty());
        LOGGER.info("received {} education records", data.size());
        return new EducationDto(data);
    }
}

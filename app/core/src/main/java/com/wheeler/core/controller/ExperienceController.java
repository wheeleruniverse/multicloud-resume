package com.wheeler.core.controller;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dto.model.ExperienceDto;
import com.wheeler.core.service.ExperienceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/experience")
public class ExperienceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceController.class);
    private final ExperienceService experienceService;

    public ExperienceController(final ExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        experienceService.experienceLoad().apply(json);
        httpResponse.setStatus(204);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public ExperienceDto retrieve(){
        final List<Experience> data = experienceService.experienceRetrieve().apply(Optional.empty());
        LOGGER.info("received {} experience records", data.size());
        return new ExperienceDto(data);
    }
}

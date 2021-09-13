package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/experience")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(final ExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json){
        experienceService.experienceLoad().apply(json);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Experience> retrieve(){
        return experienceService.experienceRetrieve().apply(Optional.empty());
    }
}

package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.service.EducationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/education")
public class EducationController {

    private final EducationService educationService;

    public EducationController(final EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json){
        educationService.educationLoad().apply(json);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Education> retrieve(){
        return educationService.educationRetrieve().apply(Optional.empty());
    }
}

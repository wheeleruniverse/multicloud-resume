package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(final ProjectService projectService){
        this.projectService = projectService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json){
        projectService.projectLoad().apply(json);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Project> retrieve(){
        return projectService.projectRetrieve().apply(Optional.empty());
    }
}

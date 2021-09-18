package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        projectService.projectLoad().apply(json);
        httpResponse.setStatus(204);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Project> retrieve(){
        return projectService.projectRetrieve().apply(Optional.empty());
    }
}

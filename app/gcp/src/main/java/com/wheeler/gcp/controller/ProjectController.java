//package com.wheeler.gcp.controller;
//
//import com.wheeler.core.dao.model.Experience;
//import com.wheeler.core.dao.model.Project;
//import com.wheeler.core.dto.model.ExperienceDto;
//import com.wheeler.core.dto.model.ProjectDto;
//import com.wheeler.core.service.ProjectService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping(value = "/project")
//public class ProjectController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
//    private final ProjectService projectService;
//
//    public ProjectController(final ProjectService projectService){
//        this.projectService = projectService;
//    }
//
//    @PostMapping(value = "/load")
//    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
//        projectService.projectLoad().apply(json);
//        httpResponse.setStatus(204);
//    }
//
//    @GetMapping(value = "/retrieve")
//    @ResponseBody
//    public ProjectDto retrieve(){
//        final List<Project> data = projectService.projectRetrieve().apply(Optional.empty());
//        LOGGER.info("received {} project records", data.size());
//        return new ProjectDto(data);
//    }
//}

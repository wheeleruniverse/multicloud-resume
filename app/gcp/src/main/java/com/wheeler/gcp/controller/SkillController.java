package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.service.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(final SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json){
        skillService.skillLoad().apply(json);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Skill> retrieve(){
        return skillService.skillRetrieve().apply(Optional.empty());
    }
}

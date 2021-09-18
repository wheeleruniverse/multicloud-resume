package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dto.model.SkillDto;
import com.wheeler.core.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/skill")
public class SkillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillController.class);
    private final SkillService skillService;

    public SkillController(final SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        skillService.skillLoad().apply(json);
        httpResponse.setStatus(204);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public SkillDto retrieve(){
        final List<Skill> data = skillService.skillRetrieve().apply(Optional.empty());
        LOGGER.info("received {} skill records", data.size());
        return new SkillDto(data);
    }
}

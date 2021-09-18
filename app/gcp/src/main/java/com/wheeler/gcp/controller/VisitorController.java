package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.service.VisitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VisitorController.class);
    private final VisitorService visitorService;

    public VisitorController(final VisitorService visitorService){
        this.visitorService = visitorService;
    }

    @PostMapping(value = "/create")
    public void create(@RequestBody final Visitor visitor){
        visitorService.visitorCreate().apply(visitor);
    }

    @GetMapping(value = "/count")
    @ResponseBody
    public Integer count(){
        Integer data = visitorService.visitorCount().apply(Optional.empty());
        LOGGER.info("received {} as the visitor count", data);
        return data;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        visitorService.visitorLoad().apply(json);
        httpResponse.setStatus(204);
    }
}

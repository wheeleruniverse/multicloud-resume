package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.service.CertificationService;
import com.wheeler.core.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/visitor")
public class VisitorController {

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
        return visitorService.visitorCount().apply(Optional.empty());
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json){
        visitorService.visitorLoad().apply(json);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public List<Visitor> retrieve(){
        return visitorService.visitorRetrieve().apply(Optional.empty());
    }
}

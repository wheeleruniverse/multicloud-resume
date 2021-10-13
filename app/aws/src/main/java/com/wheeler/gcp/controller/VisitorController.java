package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Count;
import com.wheeler.core.dto.model.CountDto;
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

    @GetMapping(value = "/count")
    @ResponseBody
    public CountDto count(){
        final Count data = visitorService.visitorCount().apply(Optional.empty());
        LOGGER.info("received {} as the visitor count", data.getValue());
        return new CountDto(data);
    }

    @PostMapping(value = "/increment")
    public void increment(final HttpServletResponse httpResponse){
        visitorService.visitorIncrement().apply(Optional.empty());
        httpResponse.setStatus(204);
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final Integer value, final HttpServletResponse httpResponse){
        visitorService.visitorLoad().apply(value);
        httpResponse.setStatus(204);
    }
}

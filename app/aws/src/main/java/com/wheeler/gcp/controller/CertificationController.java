package com.wheeler.gcp.controller;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dto.model.CertificationDto;
import com.wheeler.core.service.CertificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/certification")
public class CertificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificationController.class);
    private final CertificationService certificationService;

    public CertificationController(final CertificationService certificationService){
        this.certificationService = certificationService;
    }

    @PostMapping(value = "/load")
    public void load(@RequestBody final String json, final HttpServletResponse httpResponse){
        certificationService.certificationLoad().apply(json);
        httpResponse.setStatus(204);
    }

    @GetMapping(value = "/retrieve")
    @ResponseBody
    public CertificationDto retrieve(){
        final List<Certification> data = certificationService.certificationRetrieve().apply(Optional.empty());
        LOGGER.info("received {} certification records", data.size());
        return new CertificationDto(data);
    }
}

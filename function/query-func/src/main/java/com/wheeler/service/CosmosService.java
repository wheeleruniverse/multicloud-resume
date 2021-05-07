package com.wheeler.service;

import com.wheeler.dao.model.Certification;
import com.wheeler.dao.repository.CertificationRepository;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CosmosService {

    private final CertificationRepository certificationRepository;

    public CosmosService(final CertificationRepository certificationRepository){
        this.certificationRepository = certificationRepository;
    }

    public List<Certification> findCertification(){
        return certificationRepository.findAll();
    }
    public Certification findCertification(String id){
        return certificationRepository.findOne(id);
    }
}

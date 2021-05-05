package com.wheeler.service;

import com.wheeler.dao.model.Certification;
import com.wheeler.dao.repository.CertificationRepository;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CosmosService {

    public static Certification findCertification(String id){
        return CertificationRepository.findOne(id);
    }
    public static List<Certification> findCertification(){
        return CertificationRepository.findAll();
    }
}

//package com.wheeler.azure.service;
//
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Certification;
//import com.wheeler.azure.dao.repository.CertificationRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Service
//public class CertificationService {
//
//    private final CertificationRepository repository;
//
//    public CertificationService(final CertificationRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public Function<QueryFilter, List<Certification>> certificationRetrieve() {
//        return filter -> repository.findAll();
//    }
//}

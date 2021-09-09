//package com.wheeler.azure.service;
//
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Education;
//import com.wheeler.azure.dao.repository.EducationRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Service
//public class EducationService {
//
//    private final EducationRepository repository;
//
//    public EducationService(final EducationRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public Function<QueryFilter, List<Education>> educationRetrieve() {
//        return filter -> repository.findAll();
//    }
//}

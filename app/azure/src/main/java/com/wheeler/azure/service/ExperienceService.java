//package com.wheeler.azure.service;
//
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Experience;
//import com.wheeler.azure.dao.repository.ExperienceRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Service
//public class ExperienceService {
//
//    private final ExperienceRepository repository;
//
//    public ExperienceService(final ExperienceRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public Function<QueryFilter, List<Experience>> experienceRetrieve() {
//        return filter -> repository.findAll();
//    }
//}

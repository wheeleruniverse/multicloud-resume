//package com.wheeler.service;
//
//import com.wheeler.dao.filter.QueryFilter;
//import com.wheeler.dao.model.Experience;
//import com.wheeler.dao.model.Project;
//import com.wheeler.dao.repository.ExperienceRepository;
//import com.wheeler.dao.repository.ProjectRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Service
//public class ProjectService {
//
//    private final ProjectRepository repository;
//
//    public ProjectService(final ProjectRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public Function<QueryFilter, List<Project>> projectRetrieve() {
//        return filter -> repository.findAll();
//    }
//}

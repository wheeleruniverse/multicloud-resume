package com.wheeler.core.service;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class ProjectService {

    private final CoreRepository<Project> projectRepository;

    public ProjectService(final CoreRepository<Project> projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Bean
    public Supplier<List<Project>> projectRetrieve() {
        return projectRepository::findAll;
    }
}

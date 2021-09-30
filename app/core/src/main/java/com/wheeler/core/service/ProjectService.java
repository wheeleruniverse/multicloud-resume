package com.wheeler.core.service;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProjectService {

    private final ModelRepository<Project> projectRepository;

    public ProjectService(final ModelRepository<Project> projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Bean
    public Function<String, Optional<?>> projectLoad() {
        return (json) -> {
            projectRepository.load(json);
            return Optional.empty();
        };
    }

    @Bean
    public Function<Optional<?>, List<Project>> projectRetrieve() {
        return (o) -> projectRepository.findAll();
    }
}

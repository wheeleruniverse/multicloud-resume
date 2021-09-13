package com.wheeler.core.service;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class ProjectService {

    private final CoreRepository<Project> projectRepository;

    public ProjectService(final CoreRepository<Project> projectRepository) {
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

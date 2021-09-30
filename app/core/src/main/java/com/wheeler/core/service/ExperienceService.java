package com.wheeler.core.service;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.ModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ExperienceService {

    private final ModelRepository<Experience> experienceRepository;

    public ExperienceService(final ModelRepository<Experience> experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Bean
    public Function<String, Optional<?>>experienceLoad() {
        return (json) -> {
            experienceRepository.load(json);
            return Optional.empty();
        };
    }

    @Bean
    public Function<Optional<?>, List<Experience>> experienceRetrieve() {
        return (o) -> experienceRepository.findAll();
    }
}

package com.wheeler.core.service;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class ExperienceService {

    private final CoreRepository<Experience> experienceRepository;

    public ExperienceService(final CoreRepository<Experience> experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Bean
    public Supplier<List<Experience>> experienceRetrieve() {
        return experienceRepository::findAll;
    }
}

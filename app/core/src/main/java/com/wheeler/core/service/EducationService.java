package com.wheeler.core.service;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class EducationService {

    private final CoreRepository<Education> educationRepository;

    public EducationService(final CoreRepository<Education> educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Bean
    public Function<String, Optional<?>> educationLoad() {
        return (json) -> {
            educationRepository.load(json);
            return Optional.empty();
        };
    }

    @Bean
    public Function<Optional<?>, List<Education>> educationRetrieve() {
        return (o) -> educationRepository.findAll();
    }
}

package com.wheeler.service;

import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Education;
import com.wheeler.dao.repository.EducationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class EducationService {

    private final EducationRepository repository;

    public EducationService(final EducationRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Function<QueryFilter, List<Education>> educationRetrieve() {
        return filter -> repository.findAll();
    }
}

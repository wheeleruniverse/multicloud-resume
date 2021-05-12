package com.wheeler.service;

import com.azure.cosmos.models.CosmosItemResponse;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Skill;
import com.wheeler.dao.model.Visitor;
import com.wheeler.dao.repository.SkillRepository;
import com.wheeler.dao.repository.VisitorRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class VisitorService {

    private final VisitorRepository repository;

    public VisitorService(final VisitorRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Function<Visitor, CosmosItemResponse<Visitor>> visitorCreate() {
        return repository::save;
    }
    @Bean
    public Function<QueryFilter, List<Visitor>> visitorRetrieve() {
        return filter -> repository.findAll();
    }
}

package com.wheeler.service;

import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Skill;
import com.wheeler.dao.repository.SkillRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class SkillService {

    private final SkillRepository repository;

    public SkillService(final SkillRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Function<QueryFilter, List<Skill>> skillRetrieve() {
        return filter -> repository.findAll();
    }
}

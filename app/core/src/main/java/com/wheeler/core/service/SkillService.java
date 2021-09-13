package com.wheeler.core.service;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class SkillService {

    private final CoreRepository<Skill> skillRepository;

    public SkillService(final CoreRepository<Skill> skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Bean
    public Function<String, Optional<?>> skillLoad() {
        return (json) -> {
            skillRepository.load(json);
            return Optional.empty();
        };
    }

    @Bean
    public Function<Optional<?>, List<Skill>> skillRetrieve() {
        return (o) -> skillRepository.findAll();
    }
}

package com.wheeler.core.service;

import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class SkillService {

    private final CoreRepository<Skill> skillRepository;

    public SkillService(final CoreRepository<Skill> skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Bean
    public Supplier<List<Skill>> skillRetrieve() {
        return skillRepository::findAll;
    }
}

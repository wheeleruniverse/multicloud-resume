package com.wheeler.core.service;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.model.VisitorCount;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.core.exception.BadRequestException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class VisitorService {

    private final CoreRepository<Visitor> visitorRepository;

    public VisitorService(final CoreRepository<Visitor> visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Bean
    public Function<Optional<?>, List<VisitorCount>> visitorCount() {
        return (o) -> {
            int count = visitorRepository.count();
            return Collections.singletonList(new VisitorCount(count, null));
        };
    }
    @Bean
    public Function<Visitor, Optional<?>> visitorCreate() {
        return visitor -> {
            validateVisitor(visitor);
            visitorRepository.save(visitor);
            return Optional.empty();
        };
    }
    @Bean
    public Function<Optional<?>, List<Visitor>> visitorRetrieve() {
        return (o) -> visitorRepository.findAll();
    }

    private void validateVisitor(Visitor visitor){
        if(visitor == null){
            throw new BadRequestException("visitor is invalid");
        }
        if(visitor.getId() == null || visitor.getId().trim().isEmpty()){
            throw new BadRequestException("visitor.id is invalid");
        }
        if(visitor.getName() == null || visitor.getName().trim().isEmpty()){
            throw new BadRequestException("visitor.name is invalid");
        }
    }
}

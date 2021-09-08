package com.wheeler.core.service;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.model.VisitorCount;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.core.exception.BadRequestException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
public class VisitorService {

    private final CoreRepository<Visitor> visitorRepository;

    public VisitorService(final CoreRepository<Visitor> visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Bean
    public Supplier<List<VisitorCount>> visitorCount() {
        return () -> {
            int count = visitorRepository.count();
            return Collections.singletonList(new VisitorCount(count, null));
        };
    }
    @Bean
    public Consumer<Visitor> visitorCreate() {
        return visitor -> {
            validateVisitor(visitor);
            visitorRepository.save(visitor);
        };
    }
    @Bean
    public Supplier<List<Visitor>> visitorRetrieve() {
        return visitorRepository::findAll;
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

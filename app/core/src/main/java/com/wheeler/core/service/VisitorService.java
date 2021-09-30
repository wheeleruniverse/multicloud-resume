package com.wheeler.core.service;

import com.wheeler.core.dao.model.Count;
import com.wheeler.core.dao.repository.CountRepository;
import com.wheeler.core.exception.BadRequestException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
public class VisitorService {

    private final CountRepository visitorRepository;

    public VisitorService(final CountRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @Bean
    public Function<Optional<?>, Count> visitorCount() {
        return (o) -> visitorRepository.count();
    }

    @Bean
    public Function<Optional<?>, Optional<?>> visitorIncrement() {
        return (o) -> {
            visitorRepository.increment();
            return Optional.empty();
        };
    }

    @Bean
    public Function<Integer, Optional<?>> visitorLoad() {
        return (value) -> {
            validateCount(value);
            visitorRepository.load(value);
            return Optional.empty();
        };
    }

    private void validateCount(final Integer value){
        if(value == null){
            throw new BadRequestException("value is invalid");
        }
        if(value < 0){
            throw new BadRequestException("value should be greater than 0");
        }
    }
}

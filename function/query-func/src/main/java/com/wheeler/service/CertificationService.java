package com.wheeler.service;

import com.microsoft.azure.functions.ExecutionContext;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import com.wheeler.dao.repository.CertificationRepository;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class CertificationService {

    private final CertificationRepository repository;

    public CertificationService(final CertificationRepository repository){
        this.repository = repository;
    }

    @Bean
    public Function<Optional<QueryFilter>, List<Certification>> certificationRetrieve(ExecutionContext context) {
        return req -> {
            List<Certification> results;
            QueryFilter filter = req.orElse(new QueryFilter());
            if(filter.getId() != null){
                results = findOne(filter.getId());
            } else {
                results = findAll();
            }
            context.getLogger().info(String.format("found certification %d results", results.size()));
            return results;
        };
    }

    private List<Certification> findAll(){
        return repository.findAll();
    }
    private List<Certification> findOne(String id){
        return Collections.singletonList(repository.findOne(id));
    }
}

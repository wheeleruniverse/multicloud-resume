package com.wheeler.service;

import com.microsoft.azure.functions.ExecutionContext;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import com.wheeler.dao.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CertificationService {

    private final CertificationRepository repository;

    public CertificationService(CertificationRepository repository) {
        this.repository = repository;
    }

    @Bean
    public Function<QueryFilter, Object> certificationRetrieve() {
        return filter -> {
            return Collections.emptyList();
//            List<Certification> results;
//            if(filter.getId() != null){
//                results = findOne(filter.getId());
//            } else {
//                results = findAll();
//            }
//            context.getLogger().info(String.format("found certification %d results", results.size()));
//            return results;
        };
    }

    private List<Certification> findAll(){
        return repository.findAll();
    }
    private List<Certification> findOne(String id){
        return Collections.singletonList(repository.findOne(id));
    }
}

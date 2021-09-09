//package com.wheeler.azure.service;
//
//import com.azure.cosmos.models.CosmosItemResponse;
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Skill;
//import com.wheeler.azure.dao.model.Visitor;
//import com.wheeler.azure.dao.model.VisitorCount;
//import com.wheeler.azure.dao.repository.SkillRepository;
//import com.wheeler.azure.dao.repository.VisitorRepository;
//import com.wheeler.azure.exception.BadRequestException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.function.Function;
//
//@Service
//public class VisitorService {
//
//    private final VisitorRepository repository;
//
//    public VisitorService(final VisitorRepository repository) {
//        this.repository = repository;
//    }
//
//    @Bean
//    public Function<Visitor, CosmosItemResponse<Visitor>> visitorCreate() {
//        return visitor -> {
//            validateVisitor(visitor);
//            return repository.save(visitor);
//        };
//    }
//    @Bean
//    public Function<QueryFilter, List<Visitor>> visitorRetrieve() {
//        return filter -> repository.findAll();
//    }
//    @Bean
//    public Function<QueryFilter, List<VisitorCount>> visitorCount() {
//        return filter -> repository.countByName();
//    }
//
//
//    private void validateVisitor(Visitor visitor){
//        if(visitor == null){
//            throw new BadRequestException("visitor is invalid");
//        }
//        if(visitor.getId() == null || visitor.getId().trim().isEmpty()){
//            throw new BadRequestException("visitor.id is invalid");
//        }
//        if(visitor.getName() == null || visitor.getName().trim().isEmpty()){
//            throw new BadRequestException("visitor.name is invalid");
//        }
//    }
//}

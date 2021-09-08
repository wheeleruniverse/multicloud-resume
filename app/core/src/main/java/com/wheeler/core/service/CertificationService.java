package com.wheeler.core.service;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.CoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class CertificationService {

    private final CoreRepository<Certification> certificationRepository;

    public CertificationService(final CoreRepository<Certification> certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    @Bean
    public Supplier<List<Certification>> certificationRetrieve() {
        return certificationRepository::findAll;
    }
}

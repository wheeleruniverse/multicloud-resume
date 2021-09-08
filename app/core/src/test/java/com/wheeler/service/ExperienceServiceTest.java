package com.wheeler.service;

import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import com.wheeler.dao.model.Experience;
import com.wheeler.dao.repository.CertificationRepository;
import com.wheeler.dao.repository.ExperienceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExperienceServiceTest {

    @InjectMocks
    private ExperienceService service;

    @Mock
    private ExperienceRepository repository;

    @Test
    public void retrieveWithValidFilter(){
        final String expectId = "test519";
        final List<Experience> expect = getTestData(expectId);
        when(repository.findAll()).thenReturn(expect);

        final List<Experience> actual = service.experienceRetrieve().apply(new QueryFilter());
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getId();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).findAll();
    }

    @Test
    public void retrieveWithInvalidFilter(){
        final String expectId = "test843";
        final List<Experience> expect = getTestData(expectId);
        when(repository.findAll()).thenReturn(expect);

        final List<Experience> actual = service.experienceRetrieve().apply(null);
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getId();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).findAll();
    }

    private List<Experience> getTestData(String id){
        Experience data = new Experience();
        data.setId(id);

        return Collections.singletonList(data);
    }
}

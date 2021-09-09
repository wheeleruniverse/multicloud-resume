//package com.wheeler.service;
//
//import com.wheeler.dao.filter.QueryFilter;
//import com.wheeler.dao.model.Certification;
//import com.wheeler.dao.model.Education;
//import com.wheeler.dao.repository.CertificationRepository;
//import com.wheeler.dao.repository.EducationRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class EducationServiceTest {
//
//    @InjectMocks
//    private EducationService service;
//
//    @Mock
//    private EducationRepository repository;
//
//    @Test
//    public void retrieveWithValidFilter(){
//        final String expectId = "test519";
//        final List<Education> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Education> actual = service.educationRetrieve().apply(new QueryFilter());
//        Assertions.assertEquals(expect, actual);
//
//        final String actualId = actual.get(0).getId();
//        Assertions.assertEquals(expectId, actualId);
//        verify(repository).findAll();
//    }
//
//    @Test
//    public void retrieveWithInvalidFilter(){
//        final String expectId = "test843";
//        final List<Education> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Education> actual = service.educationRetrieve().apply(null);
//        Assertions.assertEquals(expect, actual);
//
//        final String actualId = actual.get(0).getId();
//        Assertions.assertEquals(expectId, actualId);
//        verify(repository).findAll();
//    }
//
//    private List<Education> getTestData(String id){
//        Education data = new Education();
//        data.setId(id);
//
//        return Collections.singletonList(data);
//    }
//}

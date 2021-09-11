//package com.wheeler.azure.service;
//
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Certification;
//import com.wheeler.azure.dao.model.Project;
//import com.wheeler.azure.dao.repository.CertificationRepository;
//import com.wheeler.azure.dao.repository.ProjectRepository;
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
//public class ProjectServiceTest {
//
//    @InjectMocks
//    private ProjectService service;
//
//    @Mock
//    private ProjectRepository repository;
//
//    @Test
//    public void retrieveWithValidFilter(){
//        final String expectId = "test519";
//        final List<Project> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Project> actual = service.projectRetrieve().apply(new QueryFilter());
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
//        final List<Project> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Project> actual = service.projectRetrieve().apply(null);
//        Assertions.assertEquals(expect, actual);
//
//        final String actualId = actual.get(0).getId();
//        Assertions.assertEquals(expectId, actualId);
//        verify(repository).findAll();
//    }
//
//    private List<Project> getTestData(String id){
//        Project data = new Project();
//        data.setId(id);
//
//        return Collections.singletonList(data);
//    }
//}

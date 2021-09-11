//package com.wheeler.azure.service;
//
//import com.wheeler.azure.dao.filter.QueryFilter;
//import com.wheeler.azure.dao.model.Certification;
//import com.wheeler.azure.dao.model.Skill;
//import com.wheeler.azure.dao.repository.CertificationRepository;
//import com.wheeler.azure.dao.repository.SkillRepository;
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
//public class SkillServiceTest {
//
//    @InjectMocks
//    private SkillService service;
//
//    @Mock
//    private SkillRepository repository;
//
//    @Test
//    public void retrieveWithValidFilter(){
//        final String expectId = "test519";
//        final List<Skill> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Skill> actual = service.skillRetrieve().apply(new QueryFilter());
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
//        final List<Skill> expect = getTestData(expectId);
//        when(repository.findAll()).thenReturn(expect);
//
//        final List<Skill> actual = service.skillRetrieve().apply(null);
//        Assertions.assertEquals(expect, actual);
//
//        final String actualId = actual.get(0).getId();
//        Assertions.assertEquals(expectId, actualId);
//        verify(repository).findAll();
//    }
//
//    private List<Skill> getTestData(String id){
//        Skill data = new Skill();
//        data.setId(id);
//
//        return Collections.singletonList(data);
//    }
//}

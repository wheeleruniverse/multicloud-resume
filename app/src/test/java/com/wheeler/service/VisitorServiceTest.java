package com.wheeler.service;

import com.azure.cosmos.models.CosmosItemResponse;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Visitor;
import com.wheeler.dao.model.VisitorCount;
import com.wheeler.dao.repository.VisitorRepository;
import com.wheeler.exception.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VisitorServiceTest {

    @InjectMocks
    private VisitorService service;

    @Mock
    private VisitorRepository repository;

    private CosmosItemResponse<Visitor> mockCosmosItemResponse;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void beforeEach(){
        this.mockCosmosItemResponse = mock(CosmosItemResponse.class);
    }

    @Test
    public void countWithValidFilter(){
        final String expectId = "test9";
        final List<VisitorCount> expect = getTestDataForCount(expectId);
        when(repository.countByName()).thenReturn(expect);

        final List<VisitorCount> actual = service.visitorCount().apply(new QueryFilter());
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getName();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).countByName();
    }

    @Test
    public void countWithInvalidFilter(){
        final String expectId = "test1039";
        final List<VisitorCount> expect = getTestDataForCount(expectId);
        when(repository.countByName()).thenReturn(expect);

        final List<VisitorCount> actual = service.visitorCount().apply(null);
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getName();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).countByName();
    }

    @Test
    public void createWithValidVisitor(){
        final Visitor expect = getTestData("visitor1").get(0);
        when(repository.save(any())).thenReturn(mockCosmosItemResponse);

        final CosmosItemResponse<Visitor> actual = service.visitorCreate().apply(expect);
        Assertions.assertEquals(mockCosmosItemResponse, actual);

        verify(repository).save(expect);
    }

    @Test
    public void createWithInvalidVisitor(){
        Assertions.assertThrows(BadRequestException.class, () -> service.visitorCreate().apply(null));
        verify(repository, never()).save(any());
    }

    @Test
    public void createWithInvalidVisitorId(){
        final Visitor visitor = getTestData("visitor2").get(0);

        // validate null
        visitor.setId(null);
        Assertions.assertThrows(BadRequestException.class, () -> service.visitorCreate().apply(visitor));

        // validate empty
        visitor.setId("                               ");
        Assertions.assertThrows(BadRequestException.class, () -> service.visitorCreate().apply(visitor));

        verify(repository, never()).save(any());
    }

    @Test
    public void createWithInvalidVisitorName(){
        final Visitor visitor = getTestData("visitor2").get(0);

        // validate null
        visitor.setName(null);
        Assertions.assertThrows(BadRequestException.class, () -> service.visitorCreate().apply(visitor));

        // validate empty
        visitor.setName("                               ");
        Assertions.assertThrows(BadRequestException.class, () -> service.visitorCreate().apply(visitor));

        verify(repository, never()).save(any());
    }

    @Test
    public void retrieveWithValidFilter(){
        final String expectName = "test519";
        final List<Visitor> expect = getTestData(expectName);
        when(repository.findAll()).thenReturn(expect);

        final List<Visitor> actual = service.visitorRetrieve().apply(new QueryFilter());
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getName();
        Assertions.assertEquals(expectName, actualId);
        verify(repository).findAll();
    }

    @Test
    public void retrieveWithInvalidFilter(){
        final String expectName = "test843";
        final List<Visitor> expect = getTestData(expectName);
        when(repository.findAll()).thenReturn(expect);

        final List<Visitor> actual = service.visitorRetrieve().apply(null);
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getName();
        Assertions.assertEquals(expectName, actualId);
        verify(repository).findAll();
    }

    private List<Visitor> getTestData(String name){
        Visitor data = new Visitor();
        data.setId("123");
        data.setName(name);

        return Collections.singletonList(data);
    }

    private List<VisitorCount> getTestDataForCount(String name){
        VisitorCount data = new VisitorCount();
        data.setCnt(9);
        data.setName(name);

        return Collections.singletonList(data);
    }
}

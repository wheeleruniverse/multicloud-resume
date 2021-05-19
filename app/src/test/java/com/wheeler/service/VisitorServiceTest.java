package com.wheeler.service;

import com.azure.cosmos.models.CosmosItemResponse;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Visitor;
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

    //TODO: Test Count Case

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
        final String expectId = "test519";
        final List<Visitor> expect = getTestData(expectId);
        when(repository.findAll()).thenReturn(expect);

        final List<Visitor> actual = service.visitorRetrieve().apply(new QueryFilter());
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getId();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).findAll();
    }

    @Test
    public void retrieveWithInvalidFilter(){
        final String expectId = "test843";
        final List<Visitor> expect = getTestData(expectId);
        when(repository.findAll()).thenReturn(expect);

        final List<Visitor> actual = service.visitorRetrieve().apply(null);
        Assertions.assertEquals(expect, actual);

        final String actualId = actual.get(0).getId();
        Assertions.assertEquals(expectId, actualId);
        verify(repository).findAll();
    }

    private List<Visitor> getTestData(String id){
        Visitor data = new Visitor();
        data.setId(id);
        data.setName("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36");

        return Collections.singletonList(data);
    }
}

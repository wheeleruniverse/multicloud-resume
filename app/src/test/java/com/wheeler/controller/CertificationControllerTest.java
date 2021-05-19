package com.wheeler.controller;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import com.wheeler.model.HttpRequestForQueryFilter;
import com.wheeler.model.HttpResponseMessageMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class CertificationControllerTest {

    private CertificationController spyController;
    private ExecutionContext mockContext;
    private HttpRequestMessage<Optional<QueryFilter>> mockHttpRequest;
    private QueryFilter filter;


    @BeforeEach
    public void beforeEach() {
        spyController = spy(CertificationController.class);
        mockContext = mock(ExecutionContext.class);
        mockHttpRequest = mock(HttpRequestForQueryFilter.class);
        filter = new QueryFilter();

        doReturn(Logger.getGlobal()).when(mockContext).getLogger();
        when(mockHttpRequest.getBody()).thenReturn(Optional.of(filter));
        when(mockHttpRequest.createResponseBuilder(any())).thenReturn(new HttpResponseMessageMock.HttpResponseMessageBuilderMock());
    }

    @Disabled("because can't mock handleRequest")
    public void retrieve() {

        List<Certification> data = Collections.singletonList(new Certification());
        when(spyController.handleRequest(any(), any())).thenReturn(data);

        final HttpResponseMessage response = spyController.retrieve(mockHttpRequest, mockContext);
        assertEquals(HttpStatus.valueOf(200), response.getStatus());
        assertEquals(data, response.getBody());

        verify(spyController).handleRequest(filter, mockContext);
    }
}

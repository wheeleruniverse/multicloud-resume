package com.wheeler;

import com.microsoft.azure.functions.*;
import com.wheeler.controller.CertificationController;
import com.wheeler.dao.filter.QueryFilter;
import org.junit.jupiter.api.Disabled;

import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


/**
 * Unit test for Function class.
 */
public class FunctionTest {


    /**
     * Unit test for HttpTriggerJava method.
     */
    @Disabled("until further notice")
    public void retrieveCertification() {

        // Setup
        final HttpRequestMessage<Optional<QueryFilter>> req = mock(HttpRequestForQueryFilter.class);

        doAnswer(invocation -> {
            HttpStatus status = (HttpStatus) invocation.getArguments()[0];
            return new HttpResponseMessageMock.HttpResponseMessageBuilderMock().status(status);
        }).when(req).createResponseBuilder(any(HttpStatus.class));

        final ExecutionContext context = mock(ExecutionContext.class);
        doReturn(Logger.getGlobal()).when(context).getLogger();

        // Invoke
        final HttpResponseMessage response = new CertificationController().retrieve(req, context);

        // Verify
        assertEquals(HttpStatus.valueOf(200), response.getStatus());
    }
}

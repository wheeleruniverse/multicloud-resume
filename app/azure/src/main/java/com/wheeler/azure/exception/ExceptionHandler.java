package com.wheeler.azure.exception;

import com.azure.cosmos.implementation.apachecommons.lang.exception.ExceptionUtils;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;

import java.util.logging.Level;

public class ExceptionHandler {

    private final ExecutionContext context;
    private final Exception exception;
    private final HttpRequestMessage<?> request;

    public ExceptionHandler(ExecutionContext context, Exception exception, HttpRequestMessage<?> request){
        this.context = context;
        this.exception = exception;
        this.request = request;
    }

    public HttpResponseMessage asHttpResponse(){
        return createResponse(HttpStatus.valueOf(500));
    }

    public HttpResponseMessage asHttpResponse(final HttpStatus status){
        return createResponse(status);
    }

    private HttpResponseMessage createResponse(final HttpStatus status){
        context.getLogger().log(Level.SEVERE, ExceptionUtils.getStackTrace(exception));
        return request.createResponseBuilder(status).body(exception.getMessage()).build();
    }
}

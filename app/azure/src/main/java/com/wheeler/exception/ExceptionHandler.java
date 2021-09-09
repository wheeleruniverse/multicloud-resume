package com.wheeler.exception;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.wheeler.core.exception.InternalServerErrorException;

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
        logException();
        return request.createResponseBuilder(status).body(exception.getMessage()).build();
    }

    private void logException(){

        Level level;
        if(exception instanceof InternalServerErrorException){
            level = Level.SEVERE;
        }
        else {
            level = Level.INFO;
        }
        context.getLogger().log(level, exception.toString());
    }
}

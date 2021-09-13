package com.wheeler.azure.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.azure.exception.ExceptionHandler;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class ExperienceLoadController extends AzureSpringBootRequestHandler<String, Optional<?>> {

    /**
     * loads experience data
     *
     * @param request the http request
     * @param context the execution context
     * @return a http response message
     */
    @FunctionName("experienceLoad")
    public HttpResponseMessage load(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.POST},
                    name = "req",
                    route = "experience/load")
                    HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        try {
            handleRequest(request.getBody().orElse(null), context);
            return request.createResponseBuilder(HttpStatus.valueOf(200)).build();
        }
        catch(Exception e){
            return new ExceptionHandler(context, e, request).asHttpResponse();
        }
    }
}

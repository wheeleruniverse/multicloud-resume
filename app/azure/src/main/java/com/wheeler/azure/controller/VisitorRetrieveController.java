package com.wheeler.azure.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.azure.exception.ExceptionHandler;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VisitorRetrieveController extends AzureSpringBootRequestHandler<Optional<?>, List<Visitor>> {

    /**
     * retrieves visitor data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("visitorRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    name = "req",
                    route = "visitor/retrieve")
                    HttpRequestMessage<Void> request,
            final ExecutionContext context) {

        try {
            List<Visitor> data = handleRequest(Optional.empty(), context);
            context.getLogger().info(String.format("received %d visitor records", data.size()));
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(data).build();
        }
        catch(Exception e){
            final Exception wrapped = new InternalServerErrorException(e.getMessage());
            return new ExceptionHandler(context, wrapped, request).asHttpResponse();
        }
    }
}

package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.exception.BadRequestException;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.exception.ExceptionHandler;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class VisitorCreateController extends AzureSpringBootRequestHandler<Visitor, Optional<?>> {

    /**
     * creates visitor data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("visitorCreate")
    public HttpResponseMessage create(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.POST},
                    name = "req",
                    route = "visitor/create")
                    HttpRequestMessage<Optional<Visitor>> request,
            final ExecutionContext context) {

        Visitor visitor = request.getBody().orElse(null);
        context.getLogger().info(String.format("visitor: %s", visitor));

        if (visitor == null || visitor.getName() == null){
            final Exception wrapped = new BadRequestException("visitor.name is invalid");
            return new ExceptionHandler(context, wrapped, request).asHttpResponse(HttpStatus.valueOf(400));
        }
        try {
            handleRequest(visitor, context);
            return request.createResponseBuilder(HttpStatus.valueOf(200)).build();
        }
        catch(Exception e){
            final Exception wrapped = new InternalServerErrorException(e.getMessage());
            return new ExceptionHandler(context, wrapped, request).asHttpResponse();
        }
    }
}

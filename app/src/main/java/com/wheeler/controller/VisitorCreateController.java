package com.wheeler.controller;

import com.azure.cosmos.models.CosmosItemResponse;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.model.Visitor;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

@Controller
public class VisitorCreateController extends AzureSpringBootRequestHandler<Visitor, CosmosItemResponse<Visitor>> {

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
                    HttpRequestMessage<Visitor> request,
            final ExecutionContext context) {

        Visitor visitor = request.getBody();
        context.getLogger().info(String.format("visitor: %s", visitor));

        if (visitor.getName() == null){
            return request.createResponseBuilder(HttpStatus.valueOf(400)).build();
        }
        CosmosItemResponse<Visitor> data = handleRequest(visitor, context);
        return request
                .createResponseBuilder(HttpStatus.valueOf(200))
                .body(data)
                .build();
    }
}

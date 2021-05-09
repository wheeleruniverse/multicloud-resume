package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CertificationController extends AzureSpringBootRequestHandler<QueryFilter, Object> {

    /**
     * retrieves certification data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("certificationRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    name = "req",
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
                    HttpRequestMessage<Optional<QueryFilter>> request,
            final ExecutionContext context) {

        try {
            QueryFilter filter = request.getBody().orElse(new QueryFilter());
            context.getLogger().info(String.format("'context': '%s'", context));
            context.getLogger().info(String.format("'filter' : '%s'", filter));

            Object data = handleRequest(filter, context);
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(data).build();
        }
        catch(Exception e){
            context.getLogger().severe(String.format("ERROR: '%s'", e));
            return request.createResponseBuilder(HttpStatus.valueOf(500)).body(e).build();
        }
    }
}

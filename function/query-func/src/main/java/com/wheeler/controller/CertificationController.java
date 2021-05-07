package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.List;
import java.util.Optional;

public class CertificationController extends FunctionInvoker<Optional<QueryFilter>, List<Certification>> {

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

        Optional<QueryFilter> filter = request.getBody();
        context.getLogger().info(String.format("'filter': '%s'", filter));
        return request
                .createResponseBuilder(HttpStatus.valueOf(200))
                .body(handleRequest(filter, context))
                .build();
    }
}

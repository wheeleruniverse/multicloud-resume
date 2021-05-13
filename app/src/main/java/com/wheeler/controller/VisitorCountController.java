package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.VisitorCount;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VisitorCountController extends AzureSpringBootRequestHandler<QueryFilter, List<VisitorCount>> {

    /**
     * retrieves visitor count data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("visitorCount")
    public HttpResponseMessage count(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    name = "req",
                    route = "visitor/count")
                    HttpRequestMessage<Optional<QueryFilter>> request,
            final ExecutionContext context) {

        List<VisitorCount> data = handleRequest(request.getBody().orElse(new QueryFilter()), context);
        context.getLogger().info(String.format("received %d visitor count records", data.size()));
        return request.createResponseBuilder(HttpStatus.valueOf(200)).body(data).build();
    }
}

package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Experience;
import com.wheeler.dao.model.Project;
import com.wheeler.dto.model.ProjectDto;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectController extends AzureSpringBootRequestHandler<QueryFilter, List<Project>> {

    /**
     * retrieves project data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("projectRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    name = "req",
                    route = "project/retrieve")
                    HttpRequestMessage<Optional<QueryFilter>> request,
            final ExecutionContext context) {

        List<Project> data = handleRequest(request.getBody().orElse(new QueryFilter()), context);
        context.getLogger().info(String.format("received %d project records", data.size()));
        return request.createResponseBuilder(HttpStatus.valueOf(200)).body(new ProjectDto(data)).build();
    }
}

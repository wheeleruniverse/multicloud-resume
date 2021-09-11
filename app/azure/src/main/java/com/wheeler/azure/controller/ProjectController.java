package com.wheeler.azure.controller;

import com.wheeler.azure.exception.ExceptionHandler;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dto.model.ProjectDto;
import com.wheeler.core.exception.InternalServerErrorException;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectController extends AzureSpringBootRequestHandler<Optional<?>, List<Project>> {

    /**
     * retrieves project data
     *
     * @param request the http request
     * @param context the execution context
     * @return a http response message
     */
    @FunctionName("projectRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET},
                    name = "req",
                    route = "project/retrieve")
                    HttpRequestMessage<Void> request,
            final ExecutionContext context) {

        try {
            List<Project> data = handleRequest(Optional.empty(), context);
            context.getLogger().info(String.format("received %d project records", data.size()));
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(new ProjectDto(data)).build();
        }
        catch(Exception e){
            final Exception wrapped = new InternalServerErrorException(e.getMessage());
            return new ExceptionHandler(context, wrapped, request).asHttpResponse();
        }
    }
}

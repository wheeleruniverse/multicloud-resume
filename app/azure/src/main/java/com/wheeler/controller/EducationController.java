package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Education;
import com.wheeler.dto.model.EducationDto;
import com.wheeler.exception.ExceptionHandler;
import com.wheeler.exception.InternalServerErrorException;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EducationController extends AzureSpringBootRequestHandler<QueryFilter, List<Education>> {

    /**
     * retrieves education data
     *
     * @param request the http request
     * @param context the execution context
     * @return an http response message
     */
    @FunctionName("educationRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    name = "req",
                    route = "education/retrieve")
                    HttpRequestMessage<Optional<QueryFilter>> request,
            final ExecutionContext context) {

        try {
            List<Education> data = handleRequest(request.getBody().orElse(new QueryFilter()), context);
            context.getLogger().info(String.format("received %d education records", data.size()));
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(new EducationDto(data)).build();
        }
        catch(Exception e){
            final Exception wrapped = new InternalServerErrorException(e.getMessage());
            return new ExceptionHandler(context, wrapped, request).asHttpResponse();
        }
    }
}

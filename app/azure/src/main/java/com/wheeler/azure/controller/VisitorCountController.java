package com.wheeler.azure.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.VisitorCount;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.azure.exception.ExceptionHandler;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VisitorCountController extends AzureSpringBootRequestHandler<Optional<?>, List<VisitorCount>> {

    /**
     * retrieves visitor count data
     *
     * @param request the http request
     * @param context the execution context
     * @return a http response message
     */
    @FunctionName("visitorCount")
    public HttpResponseMessage count(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET},
                    name = "req",
                    route = "visitor/count")
                    HttpRequestMessage<Void> request,
            final ExecutionContext context) {

        try {
            List<VisitorCount> data = handleRequest(Optional.empty(), context);
            context.getLogger().info(String.format("received %d visitor count records", data.size()));
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(data).build();
        }
        catch(Exception e){
            return new ExceptionHandler(context, e, request).asHttpResponse();
        }
    }
}

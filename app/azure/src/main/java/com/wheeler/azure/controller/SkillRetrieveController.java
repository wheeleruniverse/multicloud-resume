package com.wheeler.azure.controller;

import com.wheeler.azure.exception.ExceptionHandler;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.Skill;
import com.wheeler.core.dto.model.SkillDto;
import com.wheeler.core.exception.InternalServerErrorException;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SkillRetrieveController extends AzureSpringBootRequestHandler<Optional<?>, List<Skill>> {

    /**
     * retrieves skill data
     *
     * @param request the http request
     * @param context the execution context
     * @return a http response message
     */
    @FunctionName("skillRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET},
                    name = "req",
                    route = "skill/retrieve")
                    HttpRequestMessage<Void> request,
            final ExecutionContext context) {

        try {
            List<Skill> data = handleRequest(Optional.empty(), context);
            context.getLogger().info(String.format("received %d skill records", data.size()));
            return request
                    .createResponseBuilder(HttpStatus.valueOf(200))
                    .body(new SkillDto(data))
                    .build();
        }
        catch(Exception e){
            return new ExceptionHandler(context, e, request).asHttpResponse();
        }
    }
}

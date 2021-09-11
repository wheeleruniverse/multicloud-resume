package com.wheeler.azure.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dto.model.CertificationDto;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.azure.exception.ExceptionHandler;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CertificationController extends AzureSpringBootRequestHandler<Optional<?>, List<Certification>> {

    /**
     * retrieves certification data
     *
     * @param request the http request
     * @param context the execution context
     * @return a http response message
     */
    @FunctionName("certificationRetrieve")
    public HttpResponseMessage retrieve(
            @HttpTrigger(
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET},
                    name = "req",
                    route = "certification/retrieve")
                    HttpRequestMessage<Void> request,
            final ExecutionContext context) {

        try {
            List<Certification> data = handleRequest(Optional.empty(), context);
            context.getLogger().info(String.format("received %d certification records", data.size()));
            return request.createResponseBuilder(HttpStatus.valueOf(200)).body(new CertificationDto(data)).build();
        }
        catch(Exception e){
            final Exception wrapped = new InternalServerErrorException(e.getMessage());
            return new ExceptionHandler(context, wrapped, request).asHttpResponse();
        }
    }
}

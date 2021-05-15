package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.filter.QueryFilter;
import com.wheeler.dao.model.Certification;
import com.wheeler.dto.model.CertificationDto;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CertificationController extends AzureSpringBootRequestHandler<QueryFilter, List<Certification>> {

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
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    methods = {HttpMethod.GET, HttpMethod.POST},
                    name = "req",
                    route = "certification/retrieve")
                    HttpRequestMessage<Optional<QueryFilter>> request,
            final ExecutionContext context) {

        List<Certification> data = handleRequest(request.getBody().orElse(new QueryFilter()), context);
        context.getLogger().info(String.format("received %d certification records", data.size()));
        return request.createResponseBuilder(HttpStatus.valueOf(200)).body(new CertificationDto(data)).build();
    }
}

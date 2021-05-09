package com.wheeler.controller;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.wheeler.dao.model.Greeting;
import com.wheeler.dao.model.User;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class HelloHandler extends AzureSpringBootRequestHandler<User, Greeting> {

    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        User user = request.getBody()
                .filter((u -> u.getName() != null))
                .orElseGet(() -> new User(
                        request.getQueryParameters()
                                .getOrDefault("name", "<no name supplied> please provide a name as " +
                                        "either a query string parameter or in a POST body")));
        context.getLogger().info("Greeting user name: " + user.getName());
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(user, context))
                .header("Content-Type", "application/json")
                .build();
    }
}

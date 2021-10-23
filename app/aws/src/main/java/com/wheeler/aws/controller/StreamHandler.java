package com.wheeler.aws.controller;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.wheeler.aws.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("unused")
public class StreamHandler implements RequestStreamHandler {

    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> HANDLER;
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamHandler.class);

    static {
        try {
            HANDLER = SpringBootLambdaContainerHandler.getAwsProxyHandler(Main.class);
        } catch (ContainerInitializationException e) {
            final String message = "StreamHandler ContainerInitializationException";
            LOGGER.error(message);
            throw new RuntimeException(message, e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        HANDLER.proxyStream(inputStream, outputStream, context);
        outputStream.close();
    }
}

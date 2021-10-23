package com.wheeler.aws.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.wheeler.core.dao.constant.CertificationLevel;
import com.wheeler.core.dao.constant.CertificationVendor;
import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.model.partial.MonthYear;
import com.wheeler.core.utility.JsonUtil;

import java.util.Arrays;
import java.util.Collections;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        final LambdaLogger logger = context.getLogger();
        logger.log(String.format("request.getBody(): %s", request.getBody()));
        logger.log(String.format("request.getPath(): %s", request.getPath()));

        final Certification mock = new Certification();
        mock.setId("id");
        mock.setName("name");
        mock.setCredential("credential");
        mock.setDescriptions(Arrays.asList("description1", "description2"));
        mock.setExpiry(new MonthYear(9, 2021));
        mock.setIssued(new MonthYear(8, 2021));
        mock.setLevel(CertificationLevel.ASSOCIATE);
        mock.setVendor(CertificationVendor.AWS);

        return new APIGatewayProxyResponseEvent()
                .withBody(JsonUtil.toString(mock))
                .withHeaders(Collections.emptyMap())
                .withIsBase64Encoded(false)
                .withStatusCode(200);
    }
}

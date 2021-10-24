package com.wheeler.aws.dao.connection;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Service
public class DynamoConnector {

    private final String region;
    private DynamoDbClient client;

    public DynamoConnector(final String region) {
        this.region = region;
    }

    public DynamoDbClient getClient(){
        if (this.client == null){
            this.client = DynamoDbClient.builder()
                    .credentialsProvider(DefaultCredentialsProvider.create())
                    .region(Region.of(region))
                    .build();
        }
        return this.client;
    }
}

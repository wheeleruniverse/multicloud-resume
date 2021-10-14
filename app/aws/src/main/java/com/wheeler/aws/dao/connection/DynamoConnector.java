package com.wheeler.aws.dao.connection;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Service
public class DynamoConnector {

    private final String accessKey;
    private final String secretKey;
    private final String region;

    private DynamoDbClient client;

    public DynamoConnector(
        final String accessKey,
        final String secretKey,
        final String region
    ) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.region = region;
    }

    public DynamoDbClient getClient(){
        if (this.client == null){
            this.client = DynamoDbClient.builder()
                    .credentialsProvider(
                        StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey))
                    )
                    .region(Region.of(region))
                    .build();
        }
        return this.client;
    }
}

package com.wheeler.azure.dao.connection;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CosmosConnector {

    private static final Map<String, CosmosContainer> TABLES = new HashMap<>();

    private final String cosmosAuth;
    private final String cosmosHost;
    private final String cosmosName;

    private CosmosClient client;
    private CosmosDatabase database;

    public CosmosConnector(final String cosmosAuth, final String cosmosHost, final String cosmosName){
        this.cosmosAuth = cosmosAuth;
        this.cosmosHost = cosmosHost;
        this.cosmosName = cosmosName;
    }

    public CosmosClient getClient() {
        if (client == null){
            client = new CosmosClientBuilder()
                    .consistencyLevel(ConsistencyLevel.EVENTUAL)
                    .endpoint(cosmosHost)
                    .key(cosmosAuth)
                    .buildClient();
        }
        return client;
    }

    public CosmosDatabase getDatabase() {
        if (database == null){
            database = getClient().getDatabase(cosmosName);
        }
        return database;
    }

    public CosmosItemRequestOptions getItemOptions(){
        return new CosmosItemRequestOptions();
    }

    public CosmosQueryRequestOptions getQueryOptions(){
        return new CosmosQueryRequestOptions();
    }

    public CosmosContainer getTable(String name){
        if (TABLES.containsKey(name)){
            return TABLES.get(name);
        }
        final CosmosContainer container = getDatabase().getContainer(name);
        TABLES.put(name, container);
        return container;
    }
}

package com.wheeler.dao;

import com.azure.cosmos.*;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CosmosConnector {

    private static final String HOST = "https://wheeler-resume-cosmos-db.documents.azure.com:443/";
    private static final String MASTER_KEY = "21AJlZqvoyilJP6NrgEgN5N7N5tx2uNfdvnulOijesNEzuaWsUuxZ2fNBpoYzbz1nLmlUwoqaFFW4sUsT52HAw==";
    private static final CosmosClient CLIENT = buildClient();
    private static final CosmosDatabase DATABASE = CLIENT.getDatabase("prd");
    private static final Map<String, CosmosContainer> TABLES = new HashMap<>();


    public static CosmosClient getClient() {
        return CLIENT;
    }
    public static CosmosDatabase getDatabase() {
        return DATABASE;
    }
    public static CosmosContainer getTable(String name){
        if(TABLES.containsKey(name)){
            return TABLES.get(name);
        }
        CosmosContainer container = DATABASE.getContainer(name);
        TABLES.put(name, container);
        return container;
    }


    private static CosmosClient buildClient(){
        return new CosmosClientBuilder()
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .endpoint(HOST)
                .key(MASTER_KEY)
                .buildClient();
    }
}

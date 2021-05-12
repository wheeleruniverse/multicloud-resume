package com.wheeler.dao.repository;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.dao.connection.CosmosConnector;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCosmosRepository<T> {

    private final CosmosConnector cosmosConnector;
    private CosmosContainer table;

    public AbstractCosmosRepository(final CosmosConnector cosmosConnector) {
        this.cosmosConnector = cosmosConnector;
    }

    public abstract String getTableName();

    public abstract Class<T> getTableType();

    public List<T> findAll() {
        final String sql = String.format("select * from %s", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, getTableType())
                .stream().collect(Collectors.toList());
    }

    public CosmosItemResponse<T> save(T item){
        return getTable().createItem(item);
    }

    private CosmosContainer getTable() {
        if (table == null) {
            table = cosmosConnector.getTable(getTableName());
        }
        return table;
    }
}

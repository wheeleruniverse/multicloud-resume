package com.wheeler.azure.dao.repository;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.azure.dao.connection.CosmosConnector;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCosmosRepository<T> {

    protected final CosmosConnector cosmosConnector;
    private CosmosContainer table;

    public AbstractCosmosRepository(final CosmosConnector cosmosConnector) {
        this.cosmosConnector = cosmosConnector;
    }

    public abstract String getTableName();

    public abstract Class<T> getTableType();

    public int count(){
        final String sql = String.format("select count(*) from %s", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, Integer.class)
                .stream().findFirst().orElse(0);
    }

    public List<T> findAll() {
        final String sql = String.format("select * from %s", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, getTableType())
                .stream().collect(Collectors.toList());
    }

    public void save(T item) {
        final CosmosItemRequestOptions options = cosmosConnector.getItemOptions();
        getTable().createItem(item, options);
    }

    protected CosmosContainer getTable() {
        if (table == null) {
            table = cosmosConnector.getTable(getTableName());
        }
        return table;
    }
}

package com.wheeler.azure.dao.repository.base;

import com.azure.cosmos.CosmosContainer;
import com.wheeler.azure.dao.connection.CosmosConnector;

import java.lang.reflect.Array;

public abstract class AbstractCosmosRepository<T> {

    protected final CosmosConnector cosmosConnector;
    protected CosmosContainer table;

    public AbstractCosmosRepository(final CosmosConnector cosmosConnector) {
        this.cosmosConnector = cosmosConnector;
    }

    // ________________________________________________________________________________
    // abstract methods

    public abstract String getTableName();

    public abstract Class<T> getTableType();

    // ________________________________________________________________________________
    // protected methods

    protected Class<T[]> getArrayTableType(){
        final Object array = Array.newInstance(getTableType(), 0);
        return (Class<T[]>) array.getClass();
    }

    protected CosmosContainer getTable() {
        if (table == null) {
            table = cosmosConnector.getDatabase().getContainer(getTableName());
        }
        return table;
    }
}

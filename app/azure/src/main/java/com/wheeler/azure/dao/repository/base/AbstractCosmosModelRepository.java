package com.wheeler.azure.dao.repository.base;

import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.wheeler.azure.dao.connection.CosmosConnector;
import com.wheeler.core.utility.JsonUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCosmosModelRepository<T> extends AbstractCosmosRepository<T> {

    public AbstractCosmosModelRepository(final CosmosConnector cosmosConnector) {
        super(cosmosConnector);
    }

    public void delete(T item){
        deleteIterable(Collections.singletonList(item));
    }

    public void deleteArray(T[] items){
        deleteIterable(Arrays.asList(items));
    }

    public void deleteAll(){
        deleteIterable(findAll());
    }

    public <I extends Iterable<T>> void deleteIterable(I items){
        final CosmosItemRequestOptions options = cosmosConnector.getItemOptions();
        final CosmosContainer table = getTable();
        items.forEach(i -> table.deleteItem(i, options));
    }

    public List<T> findAll() {
        final String sql = String.format("select * from %s", getTableName());
        final CosmosQueryRequestOptions options = cosmosConnector.getQueryOptions();
        return getTable()
                .queryItems(sql, options, getTableType())
                .stream().collect(Collectors.toList());
    }

    public void load(final String json){
        deleteAll();
        saveArray(JsonUtil.toObject(json, getArrayTableType()));
    }

    public void save(T item) {
        saveIterable(Collections.singletonList(item));
    }

    public void saveArray(T[] items){
        saveIterable(Arrays.asList(items));
    }

    public <I extends Iterable<T>> void saveIterable(I items){
        final CosmosItemRequestOptions options = cosmosConnector.getItemOptions();
        final CosmosContainer table = getTable();
        items.forEach(i -> table.upsertItem(i, options));
    }
}

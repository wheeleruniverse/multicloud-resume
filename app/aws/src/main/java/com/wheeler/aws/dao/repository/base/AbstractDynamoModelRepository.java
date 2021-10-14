package com.wheeler.aws.dao.repository.base;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.utility.JsonUtil;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractDynamoModelRepository<T extends Model> extends AbstractDynamoRepository<T> {

    public AbstractDynamoModelRepository(final DynamoConnector dynamoConnector) {
        super(dynamoConnector);
    }

    public void delete(T item) {
        dynamoClient.deleteItem(getDeleteItemRequest(item));
    }

    public void deleteArray(T[] items){
        deleteIterable(Arrays.asList(items));
    }

    public <I extends Iterable<T>> void deleteIterable(I items){
        items.forEach(this::delete);
    }

    public void deleteAll(){
        deleteIterable(findAll());
    }

    public List<T> findAll() {
        return fromItems(dynamoClient.scan(getScanRequest()).items());
    }

    public void load(final String json){
        deleteAll();
        saveArray(JsonUtil.toObject(json, getArrayTableType()));
    }

    public void save(T item) {
        dynamoClient.putItem(getPutItemRequest(item));
    }

    public void saveArray(T[] items){
        saveIterable(Arrays.asList(items));
    }

    public <I extends Iterable<T>> void saveIterable(I items){
        items.forEach(this::save);
    }
}

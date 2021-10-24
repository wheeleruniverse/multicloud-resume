package com.wheeler.aws.dao.repository.base;

import com.wheeler.aws.dao.connection.DynamoConnector;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.dto.model.FieldDto;
import com.wheeler.core.utility.ReflectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractDynamoRepository<T extends Model> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDynamoRepository.class);

    protected final DynamoDbClient dynamoClient;

    public AbstractDynamoRepository(final DynamoConnector dynamoConnector) {
        this.dynamoClient = dynamoConnector.getClient();
    }

    // ________________________________________________________________________________
    // abstract methods

    public abstract String getTableName();

    public abstract Class<T> getTableType();

    // ________________________________________________________________________________
    // protected methods


    protected DeleteItemRequest createDeleteItemRequest(final String id){
        final FieldDto idField = new FieldDto("id", String.class, id);
        return DeleteItemRequest.builder()
                .key(Map.of(idField.getName(), Objects.requireNonNull(toValue(idField))))
                .tableName(getTableName())
                .build();
    }

    protected GetItemRequest createGetItemRequest(final String id){
        final FieldDto idField = new FieldDto("id", String.class, id);
        return GetItemRequest.builder()
                .key(Map.of(idField.getName(), Objects.requireNonNull(toValue(idField))))
                .tableName(getTableName())
                .build();
    }

    protected PutItemRequest createPutItemRequest(final T item){
        return PutItemRequest.builder()
                .item(toMap(item))
                .tableName(getTableName())
                .build();
    }

    protected ScanRequest createScanRequest(){
        return ScanRequest.builder()
                .tableName(getTableName())
                .build();
    }

    protected T fromItem(final Map<String, AttributeValue> item){
        if(item == null || item.isEmpty()){
            return null;
        }
        return fromMap(item);
    }

    protected List<T> fromItems(final List<Map<String, AttributeValue>> items){
        return items.stream().filter(i -> i != null && !i.isEmpty()).map(this::fromMap).collect(Collectors.toList());
    }

    protected Class<T[]> getArrayTableType(){
        final Object array = Array.newInstance(getTableType(), 0);
        return (Class<T[]>) array.getClass();
    }

    protected void putItem(final T item){
        dynamoClient.putItem(createPutItemRequest(item));
    }

    // ________________________________________________________________________________
    // private methods

    private T fromMap(final Map<String, AttributeValue> attributeMap){
        return fromMap(attributeMap, getTableType());
    }

    private <S> S fromMap(final Map<String, AttributeValue> attributeMap, final Class<S> clazz){
        final Map<String, Object> objectMap = ReflectUtil
                .describe(clazz).stream()
                .map(field -> {
                    final String name = field.getName();
                    final Object value = fromValue(field, attributeMap.get(name));
                    return new AbstractMap.SimpleEntry<>(name, value);
                })
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

        return ReflectUtil.construct(clazz, objectMap);
    }

    private Object fromValue(final FieldDto field, final AttributeValue attributeValue){
        final Class<?> clazz = field.getType();
        final Object value;
        if(attributeValue == null){
            value = List.class.equals(clazz) ? Collections.emptyList() : null;
        }
        else if(List.class.equals(clazz)){
            value = attributeValue.ss();
        }
        else if(clazz.isEnum()){
            value = attributeValue.s();
        }
        else if(clazz.getPackageName().startsWith("com.wheeler.")){
            value = fromMap(attributeValue.m(), clazz);
        }
        else if(Boolean.class.equals(clazz)){
            value = attributeValue.bool();
        }
        else if(Integer.class.equals(clazz)){
            value = Integer.parseInt(attributeValue.n());
        }
        else if(String.class.equals(clazz)){
            value = attributeValue.s();
        }
        else {
            value = null;
        }
        return value;
    }

    private Map<String, AttributeValue> toMap(final Object obj){
        return ReflectUtil.describe(obj).stream()
                .map(field -> new AbstractMap.SimpleEntry<>(field.getName(), toValue(field)))
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }

    private AttributeValue toValue(final FieldDto field){
        final Object value = field.getValue();
        if(value == null){
            return null;
        }

        final Class<?> clazz = field.getType();
        if(List.class.equals(clazz)){
            return toValueList(field);
        }

        final AttributeValue.Builder builder = AttributeValue.builder();
        if(clazz.isEnum()){
            builder.s(((Enum<?>)value).name());
        }
        else if(clazz.getPackageName().startsWith("com.wheeler.")){
            builder.m(toMap(value));
        }
        else if(Boolean.class.equals(clazz)){
            builder.bool((Boolean)value);
        }
        else if(Integer.class.equals(clazz)){
            builder.n(Integer.toString((Integer)value));
        }
        else if(String.class.equals(clazz)){
            builder.s((String)value);
        }
        else {
            final String error = String.format("toValue(FieldDto) unsupported class: '%s'", clazz);
            LOGGER.error(error);
            throw new IllegalArgumentException(error);
        }
        return builder.build();
    }

    // TODO: use custom annotations to track the collection type of dao types
    private AttributeValue toValueList(final FieldDto field){
        final List<?> value = (List<?>)field.getValue();
        if(value.isEmpty()){
            return null;
        }

        final AttributeValue.Builder builder = AttributeValue.builder();
        final Object idx0 = value.stream().findFirst().orElse(null);
        if(idx0 instanceof String){
            builder.ss(value.stream().map(v -> ((String)v)).collect(Collectors.toList()));
        }
        else {
            final String error = String.format("toValueList(FieldDto) unsupported class: '%s'", idx0.getClass());
            LOGGER.error(error);
            throw new IllegalArgumentException(error);
        }
        return builder.build();
    }
}

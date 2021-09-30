package com.wheeler.gcp.dao.repository.base;

import com.google.cloud.firestore.QuerySnapshot;
import com.wheeler.core.dao.model.contract.Model;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.core.utility.JsonUtil;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public abstract class AbstractFirestoreModelRepository<T extends Model> extends AbstractFirestoreRepository<T> {

    public AbstractFirestoreModelRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    public void delete(T item) {
        deleteDocument(item.getId());
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
        final QuerySnapshot snapshot = getSnapshot();
        return snapshot.getDocuments().stream()
                .map(document -> document.toObject(getTableType()))
                .collect(Collectors.toList());
    }

    public void load(final String json){
        deleteAll();
        saveArray(JsonUtil.toObject(json, getArrayTableType()));
    }

    public void save(T item) {
        setDocument(item);
    }

    public void saveArray(T[] items){
        saveIterable(Arrays.asList(items));
    }

    public <I extends Iterable<T>> void saveIterable(I items){
        items.forEach(this::save);
    }
}

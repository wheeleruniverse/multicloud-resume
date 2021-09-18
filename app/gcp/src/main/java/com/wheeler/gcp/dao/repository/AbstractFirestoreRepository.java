package com.wheeler.gcp.dao.repository;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.QuerySnapshot;
import com.wheeler.core.dao.model.contract.Entity;
import com.wheeler.core.exception.InternalServerErrorException;
import com.wheeler.core.utility.JsonUtil;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public abstract class AbstractFirestoreRepository<T extends Entity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFirestoreRepository.class);

    protected final FirestoreConnector firestoreConnector;
    private CollectionReference table;

    public AbstractFirestoreRepository(final FirestoreConnector firestoreConnector) {
        this.firestoreConnector = firestoreConnector;
    }

    public abstract String getTableName();

    public abstract Class<T> getTableType();

    public int count(){
        final QuerySnapshot snapshot = getSnapshot();
        return snapshot.getDocuments().size();
    }

    public List<T> findAll() {
        final QuerySnapshot snapshot = getSnapshot();
        return snapshot.getDocuments().stream()
                .map(document -> document.toObject(getTableType()))
                .collect(Collectors.toList());
    }

    public void load(final String json){
        getTable().listDocuments().forEach(DocumentReference::delete);
        Arrays.stream(JsonUtil.toObject(json, getArrayTableType())).forEach(this::save);
    }

    public void save(T item) {
        try {
            getTable().document(item.getId()).set(item).get();
            return;
        }
        catch (InterruptedException e) {
            LOGGER.error("save(T) InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            LOGGER.error("save(T) ExecutionException", e);
        }
        throw new InternalServerErrorException("save(T) Failed");
    }

    protected Class<T[]> getArrayTableType(){
        final Object array = Array.newInstance(getTableType(), 0);
        return (Class<T[]>) array.getClass();
    }

    protected QuerySnapshot getSnapshot(){
        try {
            return getTable().get().get();
        }
        catch (InterruptedException e) {
            LOGGER.error("getSnapshot() InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            LOGGER.error("getSnapshot() ExecutionException", e);
        }
        throw new InternalServerErrorException("getSnapshot() Failed");
    }

    protected CollectionReference getTable() {
        if (table == null) {
            table = firestoreConnector.getDatabase().collection(getTableName());
        }
        return table;
    }
}

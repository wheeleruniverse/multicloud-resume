package com.wheeler.gcp.dao.repository.base;

import com.google.cloud.firestore.*;
import com.wheeler.core.dao.model.contract.Model;
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

public abstract class AbstractFirestoreRepository<T extends Model> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFirestoreRepository.class);

    protected final FirestoreConnector firestoreConnector;
    protected CollectionReference table;

    public AbstractFirestoreRepository(final FirestoreConnector firestoreConnector) {
        this.firestoreConnector = firestoreConnector;
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

    protected void deleteDocument(final String id){
        try {
            getTable().document(id).delete().get();
            return;
        }
        catch (InterruptedException e) {
            LOGGER.error("deleteDocument() InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            LOGGER.error("deleteDocument() ExecutionException", e);
        }
        throw new InternalServerErrorException("deleteDocument() Failed");
    }

    protected DocumentSnapshot getDocument(final String id){
        try {
            return getTable().document(id).get().get();
        }
        catch (InterruptedException e) {
            LOGGER.error("getDocument() InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            LOGGER.error("getDocument() ExecutionException", e);
        }
        throw new InternalServerErrorException("getDocument() Failed");
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

    protected void setDocument(final T item){
        try {
            getTable().document(item.getId()).set(item).get();
            return;
        }
        catch (InterruptedException e) {
            LOGGER.error("setDocument(T) InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
            LOGGER.error("setDocument(T) ExecutionException", e);
        }
        throw new InternalServerErrorException("setDocument(T) Failed");
    }
}

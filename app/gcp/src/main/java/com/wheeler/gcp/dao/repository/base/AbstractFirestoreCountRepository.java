package com.wheeler.gcp.dao.repository.base;

import com.wheeler.core.dao.model.Count;
import com.wheeler.gcp.dao.connection.FirestoreConnector;

public abstract class AbstractFirestoreCountRepository extends AbstractFirestoreRepository<Count> {

    public AbstractFirestoreCountRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public Class<Count> getTableType() {
        return Count.class;
    }

    public Count count(){
        final Count current = getDocument("count").toObject(Count.class);
        return current != null ? current : new Count(getTableName(), 0);
    }

    public void increment(){
        final Count current = count();
        current.increment();

        setDocument(current);
    }

    public void load(final Integer value){
        setDocument(new Count(getTableName(), value));
    }
}

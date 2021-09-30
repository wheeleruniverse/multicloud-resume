package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CountRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreCountRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        extends AbstractFirestoreCountRepository
        implements CountRepository {

    public VisitorRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return Visitor.getTableName();
    }
}

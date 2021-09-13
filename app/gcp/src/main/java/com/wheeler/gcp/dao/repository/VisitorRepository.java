package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Visitor;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorRepository
        extends AbstractFirestoreRepository<Visitor>
        implements CoreRepository<Visitor> {

    public VisitorRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "visitor";
    }

    @Override
    public Class<Visitor> getTableType() {
        return Visitor.class;
    }
}

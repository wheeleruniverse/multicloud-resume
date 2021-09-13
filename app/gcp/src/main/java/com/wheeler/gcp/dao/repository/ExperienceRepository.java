package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository
        extends AbstractFirestoreRepository<Experience>
        implements CoreRepository<Experience> {

    public ExperienceRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "experience";
    }

    @Override
    public Class<Experience> getTableType() {
        return Experience.class;
    }
}

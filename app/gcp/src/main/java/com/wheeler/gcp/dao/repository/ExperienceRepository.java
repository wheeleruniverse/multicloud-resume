package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Experience;
import com.wheeler.core.dao.repository.ModelRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExperienceRepository
        extends AbstractFirestoreModelRepository<Experience>
        implements ModelRepository<Experience> {

    public ExperienceRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return Experience.getTableName();
    }

    @Override
    public Class<Experience> getTableType() {
        return Experience.class;
    }
}

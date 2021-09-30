package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.ModelRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository
        extends AbstractFirestoreModelRepository<Education>
        implements ModelRepository<Education> {

    public EducationRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return Education.getTableName();
    }

    @Override
    public Class<Education> getTableType() {
        return Education.class;
    }
}

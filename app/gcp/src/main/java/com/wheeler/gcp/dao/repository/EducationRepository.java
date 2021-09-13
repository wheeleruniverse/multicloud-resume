package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Education;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class EducationRepository
        extends AbstractFirestoreRepository<Education>
        implements CoreRepository<Education> {

    public EducationRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "education";
    }

    @Override
    public Class<Education> getTableType() {
        return Education.class;
    }
}

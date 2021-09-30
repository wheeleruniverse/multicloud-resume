package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.ModelRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository
        extends AbstractFirestoreModelRepository<Certification>
        implements ModelRepository<Certification> {

    public CertificationRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return Certification.getTableName();
    }

    @Override
    public Class<Certification> getTableType() {
        return Certification.class;
    }
}

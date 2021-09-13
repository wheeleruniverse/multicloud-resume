package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Certification;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class CertificationRepository
        extends AbstractFirestoreRepository<Certification>
        implements CoreRepository<Certification> {

    public CertificationRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "certification";
    }

    @Override
    public Class<Certification> getTableType() {
        return Certification.class;
    }
}

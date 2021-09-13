package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.CoreRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
        extends AbstractFirestoreRepository<Project>
        implements CoreRepository<Project> {

    public ProjectRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return "project";
    }

    @Override
    public Class<Project> getTableType() {
        return Project.class;
    }
}

package com.wheeler.gcp.dao.repository;

import com.wheeler.core.dao.model.Project;
import com.wheeler.core.dao.repository.ModelRepository;
import com.wheeler.gcp.dao.connection.FirestoreConnector;
import com.wheeler.gcp.dao.repository.base.AbstractFirestoreModelRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository
        extends AbstractFirestoreModelRepository<Project>
        implements ModelRepository<Project> {

    public ProjectRepository(final FirestoreConnector firestoreConnector) {
        super(firestoreConnector);
    }

    @Override
    public String getTableName() {
        return Project.getTableName();
    }

    @Override
    public Class<Project> getTableType() {
        return Project.class;
    }
}

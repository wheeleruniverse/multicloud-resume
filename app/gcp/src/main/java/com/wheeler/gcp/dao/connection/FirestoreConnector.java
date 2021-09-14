package com.wheeler.gcp.dao.connection;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.wheeler.core.exception.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FirestoreConnector {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirestoreConnector.class);

    private final String gcpProject;

    private Firestore database;
    private FirestoreOptions options;

    public FirestoreConnector(final String gcpProject){
        this.gcpProject = gcpProject;
    }

    public Firestore getDatabase() {
        if (database == null){
            database = getOptions().getService();
        }
        return database;
    }

    public FirestoreOptions getOptions() {
        if (options == null){
            options = FirestoreOptions.getDefaultInstance().toBuilder()
                    .setProjectId(gcpProject)
                    .setCredentials(getCredentials())
                    .build();
        }
        return options;
    }

    private Credentials getCredentials(){
        try {
            return GoogleCredentials.getApplicationDefault();
        }
        catch(IOException e){
            LOGGER.error("getCredentials()", e);
            throw new InternalServerErrorException("getCredentials() Failed");
        }
    }
}
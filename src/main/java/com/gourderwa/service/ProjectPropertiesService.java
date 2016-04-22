package com.gourderwa.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author wei.Li
 */
@Service
public class ProjectPropertiesService {

    @Value("${projectName}")
    private String projectName;
    @Value("${projectVersion}")
    private String projectVersion;
    @Value("${isInsertDemoData}")
    private boolean isInsertDemoData;

    public String getProjectName() {
        return projectName;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public boolean isInsertDemoData() {
        return isInsertDemoData;
    }
}

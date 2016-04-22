package com.gourderwa.service;

import com.gourderwa.demodata.DemoDatas;
import com.gourderwa.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate5.HibernateTemplate;
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

    /**
     * 插入测试数据
     */
    public void insertDemoData(HibernateTemplate hibernateTemplate) {

        if (!this.isInsertDemoData) {
            return;
        }

        for (Users users : DemoDatas.getUserses()) {
            hibernateTemplate.save(users);
        }
    }
}

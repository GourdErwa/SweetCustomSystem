package com.gourderwa.util;

import com.gourderwa.service.ProjectPropertiesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Wei.Li on 2016/4/21.
 */
public class StartupListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupListener.class);

    private WebApplicationContext applicationContext;
    private HibernateTemplate hibernateTemplate;
    private ProjectPropertiesService projectPropertiesService;

    public void contextDestroyed(ServletContextEvent event) {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        this.applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());

        try {
            this.hibernateTemplate = (HibernateTemplate) applicationContext.getBean("hibernateTemplate");
            this.projectPropertiesService = (ProjectPropertiesService) applicationContext.getBean("projectPropertiesService");


        } catch (Exception ignored) {
        }
    }

}

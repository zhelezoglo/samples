package com.som.blog.config;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author zhelezoglo
 */
public final class ApplicationConfig {

    //    private static final String SPRING_CONFIG_XML = "com/som/blog/blog-config.xml";
    private static final String SPRING_CONFIG_XML = "classpath*:blog-config.xml";

    /**
     * Spring context
     */
    private static GenericXmlApplicationContext springAppContext;

    /**
     * Loading Spring configs and creating default context
     *
     * @return Spring application context
     */
    public static GenericXmlApplicationContext getSpringApplicationContext() {
        if (springAppContext == null) {
            springAppContext = getSpringApplicationContext(SPRING_CONFIG_XML, ContextProfile.DATA_SOURCE_PRODUCTION, ContextProfile.SERVICES_REAL);
        }
        return springAppContext;
    }

    /**
     * Loading Spring configs and creating context
     *
     * @return Spring application context
     */
    public static GenericXmlApplicationContext getSpringApplicationContext(ContextProfile... contextProfiles) {
        if (springAppContext == null) {
            springAppContext = getSpringApplicationContext(SPRING_CONFIG_XML, contextProfiles);
        }
        return springAppContext;
    }

    private static String[] getProfilesNames(ContextProfile... contextProfiles) {
        String[] profileNames = new String[contextProfiles.length];
        int i = 0;
        for (ContextProfile contextProfile : contextProfiles) {
            profileNames[i++] = contextProfile.name();
        }
        return profileNames;
    }

    /**
     * Loading Spring configs and creating context
     *
     * @return Spring application context
     */
    protected static GenericXmlApplicationContext getSpringApplicationContext(String contextPath, ContextProfile... contextProfiles) {
        springAppContext = new GenericXmlApplicationContext();
        springAppContext.getEnvironment().setActiveProfiles(getProfilesNames(contextProfiles));
        springAppContext.load("classpath:/com/som/blog/blog-config.xml",
                "classpath*:/com/som/blog/service/*-config.xml",
                "classpath*:com/som/blog/datasource/*-config.xml");
        springAppContext.refresh();
        return springAppContext;
    }

}

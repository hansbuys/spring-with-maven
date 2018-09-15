package com.hansb.springwithmaven;

import com.hansb.springwithmaven.index.InMemoryIndexDatabase;
import com.hansb.springwithmaven.index.IndexDatabase;
import com.hansb.springwithmaven.people.InMemoryPeopleDatabase;
import com.hansb.springwithmaven.people.PeopleDatabase;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
class ComponentConfiguration {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint){
        Class<?> containingClass = injectionPoint.getDeclaredType();
        var logger = Logger.getLogger(containingClass.getName());

        logger.log(Level.INFO, "Created logger for : " + containingClass.getName());

        return logger;
    }
}

@Configuration
@Profile("production")
class PortConfiguration {

    @Bean
    public IndexDatabase getIndexDatabase() {
        return new InMemoryIndexDatabase();
    }


    @Bean
    public PeopleDatabase getPeopleDatabase() {
        return new InMemoryPeopleDatabase();
    }
}
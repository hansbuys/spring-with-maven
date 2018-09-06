package com.hansb.springwithmaven;

import com.hansb.springwithmaven.repository.Database;
import com.hansb.springwithmaven.repository.inmemory.InMemoryDatabase;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

import java.util.Objects;
import java.util.logging.Logger;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public Database getDatabase() {
        return new InMemoryDatabase();
    }

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint){
        Class<?> containingClass = injectionPoint.getDeclaredType();
        return Logger.getLogger(containingClass.getName());
    }
}

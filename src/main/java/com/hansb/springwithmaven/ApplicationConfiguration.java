package com.hansb.springwithmaven;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

@Configuration
class ApplicationConfiguration {

    @Bean
    @Scope("prototype")
    Logger logger(InjectionPoint injectionPoint){
        Class<?> containingClass = injectionPoint.getDeclaredType();
        return Logger.getLogger(containingClass.getName());
    }
}

package com.hansb.springwithmaven.people;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PersonConfiguration {

    @Bean
    public Database getPersonDatabase() {
        return new InMemoryDatabase();
    }
}

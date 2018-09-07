package com.hansb.springwithmaven.index;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class IndexConfiguration {

    @Bean
    public Database getIndexDatabase() {
        return new InMemoryDatabase();
    }
}

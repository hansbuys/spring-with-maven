package com.hansb.springwithmaven.index;

import com.hansb.springwithmaven.Application;
import com.hansb.springwithmaven.ControllerTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@SpringBootTest(classes = IndexControllerTestBase.TestConfig.class)
abstract class IndexControllerTestBase extends ControllerTestBase {

    @Configuration
    @Import(Application.class)
    public static class TestConfig
    {
        @Bean
        @Primary
        public Database getDatabase()
        {
            return new DatabaseFake();
        }
    }

    @Autowired
    protected Database database;

    void withDescription(String description) {
        getDatabase().withDescription(description);
    }

    private DatabaseFake getDatabase() {
        return (DatabaseFake)database;
    }

    void withDatabaseUnavailable(String errorMessage) {
        getDatabase().withDatabaseUnavailable(errorMessage);
    }
}


package com.hansb.springwithmaven;

import com.hansb.springwithmaven.fakes.TestDatabase;
import com.hansb.springwithmaven.repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@SpringBootTest(classes = HomeControllerTests.TestConfig.class)
public abstract class HomeControllerTestBase extends ControllerTestBase {

    @Configuration
    @Import(Application.class)
    protected static class TestConfig
    {
        @Bean
        @Primary
        public Database getDatabase()
        {
            return new TestDatabase();
        }
    }

    @Autowired
    protected Database database;

    protected void withDescription(String description) {
        getDatabase().withDescription(description);
    }

    private TestDatabase getDatabase() {
        return (TestDatabase)database;
    }

    protected void withDatabaseUnavailable(String errorMessage) {
        getDatabase().withDatabaseUnavailable(errorMessage);
    }
}

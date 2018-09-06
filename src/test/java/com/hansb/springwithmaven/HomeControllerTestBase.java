package com.hansb.springwithmaven;

import com.hansb.springwithmaven.fakes.DatabaseFake;
import com.hansb.springwithmaven.repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest(classes = HomeControllerTestBase.TestConfig.class)
public abstract class HomeControllerTestBase extends ControllerTestBase {

    @Autowired
    protected Database database;

    protected void withDescription(String description) {
        getDatabase().withDescription(description);
    }

    private DatabaseFake getDatabase() {
        return (DatabaseFake)database;
    }

    protected void withDatabaseUnavailable(String errorMessage) {
        getDatabase().withDatabaseUnavailable(errorMessage);
    }
}


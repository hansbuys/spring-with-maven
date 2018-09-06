package com.hansb.springwithmaven.fakes;

import com.hansb.springwithmaven.repository.Database;

public class DatabaseFake implements Database {

    private String description;
    private boolean shouldThrow;
    private String errorMessage;

    public void withDescription(String description) {
        this.description = description;
    }

    public void withDatabaseUnavailable(String errorMessage) {
        this.shouldThrow = true;
        this.errorMessage = errorMessage;
    }

    @Override
    public String description() throws Exception {
        if (shouldThrow)
            throw new Exception(errorMessage);

        return description;
    }
}

package com.hansb.springwithmaven.repository.inmemory;

import com.hansb.springwithmaven.repository.Database;

public class InMemoryDatabase implements Database {
    @Override
    public String description() {
        return "This database stores things in memory. All storage will reset on restart.";
    }
}

package com.hansb.springwithmaven.index.inmemory;

import com.hansb.springwithmaven.index.IndexDatabase;

public class InMemoryIndexDatabase implements IndexDatabase {
    @Override
    public String description() {
        return "This database stores things in memory. All storage will reset on restart.";
    }
}

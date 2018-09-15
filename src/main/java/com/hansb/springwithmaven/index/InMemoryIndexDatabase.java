package com.hansb.springwithmaven.index;

public class InMemoryIndexDatabase implements IndexDatabase {
    @Override
    public String description() {
        return "This database stores things in memory. All storage will reset on restart.";
    }
}

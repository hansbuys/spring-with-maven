package com.hansb.springwithmaven.index;

class InMemoryDatabase implements Database {
    @Override
    public String description() {
        return "This database stores things in memory. All storage will reset on restart.";
    }
}

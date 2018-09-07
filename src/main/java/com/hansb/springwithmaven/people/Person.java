package com.hansb.springwithmaven.people;

class Person {
    private final String name;

    Person(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused") // Used by JSON serializer.
    public String getName() {
        return name;
    }
}

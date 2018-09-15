package com.hansb.springwithmaven.people;

class Person {
    private final int id;
    private final String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("unused") // Used by JSON serializer.
    public String getName() {
        return name;
    }

    @SuppressWarnings({"unused", "WeakerAccess"}) // Used by JSON serializer.
    public int getId() {
        return id;
    }
}

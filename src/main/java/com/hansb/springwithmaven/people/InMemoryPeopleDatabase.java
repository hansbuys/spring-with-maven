package com.hansb.springwithmaven.people;

import java.util.Arrays;
import java.util.Collection;

public class InMemoryPeopleDatabase implements PeopleDatabase {
    @Override
    public Collection<Person> getPeople() {
        return Arrays.asList(
                new Person(1, "Frank Grimes"),
                new Person(2, "James Gordon"),
                new Person(3, "Joe Schneider")
        );
    }

    @Override
    public Person getPerson(int id) {
        return getPeople()
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

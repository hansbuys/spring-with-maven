package com.hansb.springwithmaven.people;

import java.util.Arrays;
import java.util.Collection;

public class InMemoryPeopleDatabase implements PeopleDatabase {
    @Override
    public Collection<Person> getPeople() {
        return Arrays.asList(
                new Person("Frank Grimes"),
                new Person("James Gordon"),
                new Person("Joe Schneider")
        );
    }
}

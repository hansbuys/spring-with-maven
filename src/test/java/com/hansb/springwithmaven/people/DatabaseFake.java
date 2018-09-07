package com.hansb.springwithmaven.people;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class DatabaseFake implements Database {
    public DatabaseFake() {
        people = new ArrayList<>();
    }

    @Override
    public Collection<Person> getPeople() {
        return this.people.stream().map(person -> new Person(person.getName())).collect(Collectors.toList());
    }

    public static class PersonFake {

        private final String name;

        public PersonFake(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private final List<PersonFake> people;

    public void withPeople(Collection<PersonFake> people) {
        this.people.addAll(people);
    }
}

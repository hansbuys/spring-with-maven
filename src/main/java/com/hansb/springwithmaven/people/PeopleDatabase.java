package com.hansb.springwithmaven.people;

import java.util.Collection;

public interface PeopleDatabase {
    Collection<Person> getPeople();

    Person getPerson(int id);
}

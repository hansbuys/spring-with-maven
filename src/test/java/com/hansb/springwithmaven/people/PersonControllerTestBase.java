package com.hansb.springwithmaven.people;

import com.hansb.springwithmaven.ControllerTestBase;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;

abstract class PersonControllerTestBase extends ControllerTestBase {

    private void withPeople(Collection<Person> people) {
        when(peopleDatabase.getPeople()).thenReturn(people);
        people.forEach(person -> when(peopleDatabase.getPerson(person.getId())).thenReturn(person));
    }

    void withPeople(Person... people) {
        withPeople(Arrays.asList(people));
    }
}


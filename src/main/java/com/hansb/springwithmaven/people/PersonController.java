package com.hansb.springwithmaven.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PeopleDatabase database;

    @Autowired
    PersonController(PeopleDatabase database) {
        this.database = database;
    }

    @RequestMapping("")
    public ResponseEntity<Iterable<Person>> index() {
        Collection<Person> people = database.getPeople();

        return ResponseEntity.ok(people);
    }

    @RequestMapping("{id}")
    public ResponseEntity<Person> index(@PathVariable("id") int id) {
        var person = database.getPerson(id);

        if (person == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(person);
    }
}

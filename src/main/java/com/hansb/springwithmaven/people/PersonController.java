package com.hansb.springwithmaven.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final Database database;

    @Autowired
    PersonController(Database database) {
        this.database = database;
    }

    @RequestMapping("")
    public ResponseEntity<Iterable<Person>> index() {
        Collection<Person> people = database.getPeople();

        return ResponseEntity.ok(people);
    }
}

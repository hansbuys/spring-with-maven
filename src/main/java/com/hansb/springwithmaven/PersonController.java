package com.hansb.springwithmaven;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("")
    public ResponseEntity<Iterable<Person>> index() {
        return ResponseEntity.ok(new ArrayList<>());
    }
}

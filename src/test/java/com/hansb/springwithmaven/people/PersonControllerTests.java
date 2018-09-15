package com.hansb.springwithmaven.people;

import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonControllerTests extends PersonControllerTestBase {

    @Test
    public void indexDisplaysEmptyListWhenNoPeopleInDatabase() throws Exception {
        executeRequest("/person")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void indexDisplaysAllPeopleInDatabase() throws Exception {
        withPeople(
                new Person(1, "Dilbert"),
                new Person(2, "Dogbert")
        );

        executeRequest("/person")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("[0].name").value("Dilbert"))
                .andExpect(jsonPath("[1].name").value("Dogbert"))
                .andExpect(jsonPath("[2]").doesNotExist());
    }

    @Test
    public void indexWithParameterDisplaysSpecificPersonFromDatabase() throws Exception {
        withPeople(
                new Person(1, "Dilbert"),
                new Person(2, "Dogbert")
        );

        executeRequest("/person/1")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Dilbert"));

        executeRequest("/person/2")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("Dogbert"));

        executeRequest("/person/3")
                .andExpect(status().isNotFound());
    }
}

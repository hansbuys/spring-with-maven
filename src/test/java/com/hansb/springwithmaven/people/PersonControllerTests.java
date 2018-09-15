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
                new Person("Dilbert"),
                new Person("Dogbert")
        );

        executeRequest("/person")
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("[0].name").value("Dilbert"))
                .andExpect(jsonPath("[1].name").value("Dogbert"))
                .andExpect(jsonPath("[2]").doesNotExist());
    }
}

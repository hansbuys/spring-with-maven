package com.hansb.springwithmaven;

import org.junit.Test;

import java.util.logging.Logger;

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
}

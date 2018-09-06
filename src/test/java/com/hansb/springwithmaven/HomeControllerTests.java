package com.hansb.springwithmaven;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HomeControllerTests extends HomeControllerTestBase {

    @Test
    public void returnsDescriptionFromDatabase() throws Exception {
        String databaseDescription = "test";

        withDescription(databaseDescription);

        executeRequest("/")
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(databaseDescription)));
    }

    @Test
    public void returnsBadRequestWhenDatabaseUnavailable() throws Exception {
        String errorMessage = "Database unavailable.";

        withDatabaseUnavailable(errorMessage);

        executeRequest("/")
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo(errorMessage)));
    }
}
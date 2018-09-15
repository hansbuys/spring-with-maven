package com.hansb.springwithmaven.index;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexControllerTests extends IndexControllerTestBase {

    @Test
    public void returnsBadRequestWhenDatabaseUnavailable() throws Exception {
        String errorMessage = "IndexDatabase unavailable.";

        withDatabaseUnavailable(errorMessage);

        executeRequest("/")
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo(errorMessage)));
    }

    @Test
    public void returnsDescriptionFromDatabase() throws Exception {
        String databaseDescription = "test";

        withDescription(databaseDescription);

        executeRequest("/")
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(databaseDescription)));
    }
}
package com.hansb.springwithmaven;

import com.hansb.springwithmaven.index.IndexDatabase;
import com.hansb.springwithmaven.people.PeopleDatabase;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest()
@ActiveProfiles("testing")
public abstract class ControllerTestBase {

    @MockBean
    protected PeopleDatabase peopleDatabase;
    @MockBean
    protected IndexDatabase indexDatabase;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private Logger logger;

    protected ResultActions executeRequest(String urlTemplate) throws Exception {
        var request = MockMvcRequestBuilders.get(urlTemplate)
                .accept(MediaType.APPLICATION_JSON);

        return mvc.perform(request).andDo(mvcResult -> {
            var content = mvcResult.getResponse().getContentAsString();
            var status = mvcResult.getResponse().getStatus();

            logger.log(Level.INFO, String.format("Request '%s' returned status %d: '%s'.", urlTemplate, status, content));
        });
    }
}


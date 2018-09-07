package com.hansb.springwithmaven;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
public abstract class ControllerTestBase {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected Logger logger;

    protected ResultActions executeRequest(String urlTemplate) throws Exception {
        ResultActions result = mvc.perform(MockMvcRequestBuilders.get(urlTemplate).accept(MediaType.APPLICATION_JSON)).andDo(mvcResult -> {
            String content = mvcResult.getResponse().getContentAsString();

            logger.log(Level.INFO, String.format("Request '%s' returned '%s'.", urlTemplate, content));
        });



        return result;
    }
}

package com.hansb.springwithmaven;

import com.hansb.springwithmaven.repository.PersonDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest(classes = PersonControllerTestBase.TestConfig.class)
public abstract class PersonControllerTestBase extends ControllerTestBase {

    @Autowired
    protected PersonDatabase database;
}


package com.hansb.springwithmaven.people;

import com.hansb.springwithmaven.Application;
import com.hansb.springwithmaven.ControllerTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.Collection;

@SpringBootTest(classes = PersonControllerTestBase.TestConfig.class)
abstract class PersonControllerTestBase extends ControllerTestBase {

    @Configuration
    @Import(Application.class)
    public static class TestConfig
    {
        @Bean
        @Primary
        public Database getDatabase()
        {
            return new DatabaseFake();
        }
    }

    @Autowired
    protected Database database;

    protected DatabaseFake getDatabase() {
        return (DatabaseFake)database;
    }

    protected void withPeople(Collection<DatabaseFake.PersonFake> people) {
        this.getDatabase().withPeople(people);
    }

    protected void withPeople(DatabaseFake.PersonFake... people) {
        withPeople(Arrays.asList(people));
    }
}


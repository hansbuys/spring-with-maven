package com.hansb.springwithmaven.people;

import java.util.Collection;

interface Database {
    Collection<Person> getPeople();
}

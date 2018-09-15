package com.hansb.springwithmaven.index;

import com.hansb.springwithmaven.ControllerTestBase;

import static org.mockito.Mockito.when;

abstract class IndexControllerTestBase extends ControllerTestBase {

    void withDescription(String description) throws Exception {
        when(indexDatabase.description()).thenReturn(description);
    }

    void withDatabaseUnavailable(String errorMessage) throws Exception {
        when(indexDatabase.description()).thenThrow(new Exception(errorMessage));
    }
}


package com.hansb.springwithmaven.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class IndexController {

    private final IndexDatabase database;
    private final Logger logger;

    @Autowired
    public IndexController(IndexDatabase database, Logger logger) {
        this.database = database;
        this.logger = logger;
    }

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        logger.log(Level.INFO, "Loading index...");

        try {
            logger.log(Level.FINE, "Getting description...");
            String description = database.description();
            logger.log(Level.FINE, "Description = '%s'.", description);

            return ResponseEntity.ok(description);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to get description.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

package com.hansb.springwithmaven;

import com.hansb.springwithmaven.repository.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
import java.util.logging.Level;

@RestController
public class HomeController {

    private final Database database;
    private final Logger logger;

    @Autowired
    public HomeController(Database database, Logger logger) {
        this.database = database;
        this.logger = logger;
    }

    @RequestMapping("/")
    public ResponseEntity<String> index() {
        logger.log(Level.INFO, "Loading index...");

        try {
            logger.log(Level.FINE, "Getting description...");
            String description = database.description();
            logger.log(Level.FINE, "Description = '{0}'.", description);

            return ResponseEntity.ok(description);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to get description.", e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

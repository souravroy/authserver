package com.db2rest.oauth2.authserver.rest;

import com.db2rest.oauth2.authserver.config.DataBaseProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HomeController {

    private final DataBaseProperties dataBaseProperties;

    private final DataSource dataSource;

    public HomeController(DataBaseProperties dataBaseProperties, DataSource dataSource) {
        this.dataBaseProperties = dataBaseProperties;
        this.dataSource = dataSource;
    }

    @GetMapping("/")
    public String message() {
        return "Authentication Successfull!";
    }
}

package com.lxisoft.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MovieControllerResource controller
 */
@RestController
@RequestMapping("/api/movie-controller")
public class MovieControllerResource {

    private final Logger log = LoggerFactory.getLogger(MovieControllerResource.class);

    /**
    * GET add
    */
    @GetMapping("/add")
    public String add() {
        return "add";
    }

}

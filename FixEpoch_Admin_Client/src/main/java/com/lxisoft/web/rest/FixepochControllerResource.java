package com.lxisoft.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FixepochControllerResource controller
 */
@RestController
@RequestMapping("/api/fixepoch-controller")
public class FixepochControllerResource {

    private final Logger log = LoggerFactory.getLogger(FixepochControllerResource.class);

    /**
    * GET add
    */
    @GetMapping("/add")
    public String add() {
        return "add";
    }

}

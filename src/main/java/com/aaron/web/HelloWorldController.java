package com.aaron.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {
    private static Logger logger = LogManager.getLogger(HelloWorldController.class);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        return "Hello World!";
    }
}

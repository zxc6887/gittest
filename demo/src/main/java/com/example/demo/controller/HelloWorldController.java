package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Value("${com.neo.title}")
    private String title;
    @Value("${com.neo.description}")
    private String description;

    @RequestMapping("/hello")
    public String index() {
        logger.info("title is :{}",title);
        logger.info("description is :{}",description);
        return "Hello World";
    }

}
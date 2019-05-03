package com.orion.loggerappdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PingController
 */
@RestController
@RequestMapping(path = "/")
public class PingController {

    @GetMapping
    public String hello() {
        return "Hello people!!!";
    }
    
}
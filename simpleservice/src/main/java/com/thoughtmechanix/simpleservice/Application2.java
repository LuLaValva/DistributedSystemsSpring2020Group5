package com.thoughtmechanix.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
@RequestMapping(value="test")
public class Application2 {

    @RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
    public String testing( @PathVariable("firstName") String firstName,
                         @PathVariable("lastName") String lastName) {

        return String.format("{\"message\":\"Testing for %s %s\"}", firstName, lastName);
    }
}
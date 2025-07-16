package com.example.demo.challenge_lab1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController // Marks this class as a REST controller
public class HelloWorldController {

    @Value("${app.greeting.message}") // Inject value from application.properties
    private String customGreeting;

    @GetMapping("/hello")
    public String sayHello() {
        return customGreeting; // Now returns the custom message
    }

    @GetMapping("/greet/{name}") // This path now expects a dynamic 'name' part
    public String greetUser(@PathVariable String name) { // @PathVariable maps the URL part to this parameter
        return "Greetings, " + name + "!";
    }
}
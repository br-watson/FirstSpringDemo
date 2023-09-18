package com.sky.dog.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @GetMapping("/hello") // 'maps' this method to a GET request at /hello
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/helloyou")
    public String helloYou(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }
}

package br.com.project.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.api.models.People;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
public class Controller {
    @GetMapping("")
    public String message() {
        return "Hello World!";
    }

    @GetMapping("/greeting")
    public String greetings() {
        return "Welcome!!";
    }

    @GetMapping("/greeting/{name}")
    public String greetings(@PathVariable String name) {
        return "Welcome " + name;
    }
    
    @PostMapping("/people")
    public People people(@RequestBody People p) {
        return p;
    }
}

package br.com.project.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.api.models.People;
import br.com.project.api.repository.PeopleRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PeopleRepository action;

    @PostMapping("/api")
    public People register(@RequestBody People obj) {
        return action.save(obj);
    }

    @GetMapping("/api")
    public List<People> select() {
        return action.findAll();
    }

    @GetMapping("/api/{code}")
    public People selectByCode(@PathVariable int code) {
        return action.findByCode(code); 
    }

    @PutMapping("/api")
    public People edit(@RequestBody People obj) {
        return action.save(obj);
    }

    @DeleteMapping("/api/{code}")
    public void remove(@PathVariable int code) {
        People obj = selectByCode(code);

        action.delete(obj);
    }

    @GetMapping("/api/count")
    public long count() {
        return action.count();
    }

    @GetMapping("/api/orderNames")
    public List<People> orderByNames() {
        return action.findByOrderByNameDesc();
    }

    @GetMapping("/api/orderNamesV2")
    public List<People> orderByNamesV2() {
        return action.findByNameOrderByAgeAsc("Matheus");
    }

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

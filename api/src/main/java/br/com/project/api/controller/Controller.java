package br.com.project.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.project.api.models.People;
import br.com.project.api.repository.PeopleRepository;
import br.com.project.api.services.ServiceApi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private PeopleRepository action;

    @Autowired
    private ServiceApi service;

    @PostMapping("/api")
    // public People register(@RequestBody People obj) {
    public ResponseEntity<?> register(@RequestBody People obj) {
        // return action.save(obj);
        return service.register(obj);
    }

    @GetMapping("/api")
    public ResponseEntity<?> select() {
        // return action.findAll();
        return service.selectAll();
    }

    @GetMapping("/api/{code}")
    public ResponseEntity<?> selectByCode(@PathVariable int code) {
        return service.selectByCode(code);
    }

    @PutMapping("/api")
    public ResponseEntity<?> edit(@RequestBody People obj) {
        return service.edit(obj);
    }

    @DeleteMapping("/api/{code}")
    public ResponseEntity<?> remove(@PathVariable int code) {
        return service.remove(code);
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

    @GetMapping("/api/nameContain")
    public List<People> nameContain() {
        return action.findByNameContaining("u");
    }

    @GetMapping("api/startsWith")
    public List<People> nameStartsWith() {
        return action.findByNameStartsWith("Ma");
    }

    @GetMapping("api/endsWith")
    public List<People> nameEndsWith() {
        return action.findByNameEndsWith("th");
    }

    @GetMapping("api/sumAges")
    public int sumAges() {
        return action.sumAges();
    }

    @GetMapping("api/ageGreaterEqual")
    public List<People> ageGreaterEqual() {
        return action.ageGreaterEqual(18);
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

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

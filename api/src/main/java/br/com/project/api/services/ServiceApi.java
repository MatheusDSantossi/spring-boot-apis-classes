package br.com.project.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.project.api.models.Message;
import br.com.project.api.models.People;
import br.com.project.api.repository.PeopleRepository;

@Service
public class ServiceApi {
    @Autowired
    private Message message;

    @Autowired
    private PeopleRepository action;
    
    // Method to register people
    
    public ResponseEntity<?> register(People obj) {
        if (obj.getName().equals("")) {
            message.setMessage("The name needs to be filled.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getAge() <= 0) {
            message.setMessage("Provide a correct age.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else {
            // action.save(obj);
            return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);
        }
    }

    // Method to select people
    public ResponseEntity<?> selectAll() {
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }

    // Method to select people through code
    public ResponseEntity<?> selectByCode(int code) {
        if(action.countByCode(code) == 0) {
            message.setMessage("People not found.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            // return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(action.findByCode(code), HttpStatus.OK);
    }

    // Method to edit data
    public ResponseEntity<?> edit(People obj) {
        if(action.countByCode(obj.getCode()) == 0) {
            message.setMessage("The code provide doesn't exist.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if (obj.getName().equals("")){ 
            message.setMessage("It's necessary to provide a name");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (obj.getAge() <= 0) {
            message.setMessage("Age must be greater than 0");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
    }

    // Method to remove registers
    public ResponseEntity<?> remove(int code) {
        if(action.countByCode(code) == 0) {
            message.setMessage("The code provide doesn't exist.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        People people = action.findByCode(code);

        action.delete(people);

        message.setMessage("People removed with success");

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

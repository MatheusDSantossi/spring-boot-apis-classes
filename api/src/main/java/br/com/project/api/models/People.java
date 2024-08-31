package br.com.project.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
// @Table(name="people_2")
public class People {
    // Atribute
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String name;
    private int age;

    // Get and Set
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    

}

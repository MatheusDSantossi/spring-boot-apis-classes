package br.com.project.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.api.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer> {
    List<People> findAll(); 

    People findByCode(int code);

    // List<People> findByOrderByName();
    List<People> findByOrderByNameDesc();

    List<People> findByNameOrderByAgeAsc(String name);
    
}

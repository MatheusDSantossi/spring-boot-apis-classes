package br.com.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

    List<People> findByNameContaining(String term);

    List<People> findByNameStartsWith(String term);

    List<People> findByNameEndsWith(String term);

    @Query(value = "SELECT SUM(age) FROM people", nativeQuery = true)
    int sumAges();
    
    @Query(value = "SELECT * FROM people WHERE age >= :age", nativeQuery = true)
    List<People> ageGreaterEqual(int age);
}

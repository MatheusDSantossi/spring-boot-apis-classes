package br.com.project.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.api.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Integer> {
    
}

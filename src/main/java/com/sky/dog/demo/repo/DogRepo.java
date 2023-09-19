package com.sky.dog.demo.repo;

import com.sky.dog.demo.domain.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepo extends JpaRepository<Dog, Integer> {
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    Dog findByNameIgnoreCase(String name);
}

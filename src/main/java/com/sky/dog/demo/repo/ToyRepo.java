package com.sky.dog.demo.repo;


import com.sky.dog.demo.domain.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepo extends JpaRepository<Toy, Integer> {
}

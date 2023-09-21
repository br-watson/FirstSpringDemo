package com.sky.dog.demo.services;


import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.dtos.DogDTO;
import com.sky.dog.demo.repo.DogRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DogServiceDBTest {


    @Autowired
    private DogService service;

    @MockBean
    private DogRepo repo;

    @Test
    void testUpdate() {
        int id = 24;
        Optional<Dog> found = Optional.of(new Dog( id, "Barry", 80, "black", "pit bull"));

        Mockito.when(this.repo.existsById(id)).thenReturn(true);
        Mockito.when(this.repo.findById(id)).thenReturn(found);

        Dog updated = new Dog(id, "Harry", 810, "cyan", "labradoodle");

        Mockito.when(this.repo.save(updated)).thenReturn(updated);

        DogDTO updatedDTO = new DogDTO(updated);

        Assertions.assertEquals(updatedDTO, this.service.updateDog(id, "Harry", 810, "cyan", "labradoodle"));

        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
        Mockito.verify(this.repo, Mockito.times(1)).findById(id);
        Mockito.verify(this.repo, Mockito.times(1)).save(updated);
    }
}

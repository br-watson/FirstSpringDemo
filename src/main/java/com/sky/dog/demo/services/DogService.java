package com.sky.dog.demo.services;
import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.dtos.DogDTO;

import java.util.List;

public interface DogService {

    Dog createDog(Dog dog);

    DogDTO getDog(int id);

    List<DogDTO> getAllDogs();

    DogDTO updateDog(int id, String name, Integer age, String colour, String breed);

    String removeDog(int id);

    DogDTO getDogByName(String name);

}
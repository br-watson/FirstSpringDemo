package com.sky.dog.demo.services;
import com.sky.dog.demo.domain.Dog;

import java.util.List;

public interface DogService {

    Dog createDog(Dog dog);

    Dog getDog(int id);

    List<Dog> getAllDogs();

    Dog updateDog(int id, String name, Integer age, String colour, String breed);

    String removeDog(int id);

}
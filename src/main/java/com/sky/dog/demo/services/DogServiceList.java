package com.sky.dog.demo.services;

import com.sky.dog.demo.domain.Dog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Primary
public class DogServiceList implements DogService {

    private final List<Dog> dogs = new ArrayList<>();

    @Override
    public Dog createDog(Dog d) {
        dogs.add(d);
        return this.dogs.get(this.dogs.size() - 1);
    }

    @Override
    public Dog getDog(int id) {
        if (id >= 0 && id < dogs.size()) {
            return dogs.get(id);
        }
        else
            return null;
    }

    @Override
    public List<Dog> getAllDogs() {
        return this.dogs;
    }

    @Override
    public Dog updateDog(int id, String name, Integer age, String colour, String breed) {
        if (id < 0 || id >= dogs.size())
            return null;
        Dog toUpdate = dogs.get(id);
        if (name != null)
            toUpdate.setName(name);
        if (age != null)
            toUpdate.setAge(age);
        if (colour != null)
            toUpdate.setColour(colour);
        if (breed != null)
            toUpdate.setBreed(breed);
        return toUpdate;
    }

    @Override
    public String removeDog(int id) {
        if (id >= 0 && id < dogs.size()) {
            dogs.remove(id);
            return "Dog with id " + id + " removed.";
        }
        else
            return "Dog with id " + id + " not found.";
    }

    @Override
    public Dog getDogByName(String name) {
        return null;
    }
}

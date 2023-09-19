package com.sky.dog.demo.services;

import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.repo.DogRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary //tells Spring to use this over PersonServiceList
public class DogServiceDB implements DogService {

    private final DogRepo repo;

    public DogServiceDB(DogRepo repo) {
        this.repo = repo;
    }

    @Override
    public Dog createDog(Dog d) {
        return this.repo.save(d);
    }

    @Override
    public Dog getDog(int id) {
        //might be a person or not
//        Optional<Dog> found = this.repo.findById(id);
//        return found.get();

        return this.repo.findById(id).orElse(null);
    }

    @Override
    public List<Dog> getAllDogs() {
        return this.repo.findAll();
    }

    @Override
    public Dog updateDog(int id, String name, Integer age, String colour, String breed) {
        if (!this.repo.existsById(id)) {
            return null;
        }
        Dog toUpdate = this.getDog(id);
        if (name != null)
            toUpdate.setName(name);
        if (age != null)
            toUpdate.setAge(age);
        if (colour != null)
            toUpdate.setColour(colour);
        if (breed != null)
            toUpdate.setBreed(breed);

        return this.repo.save(toUpdate);
    }

    @Override
    public String removeDog(int id) {
        if (this.repo.existsById(id)) {
            this.repo.deleteById(id);
            return "Dog with id " + id + " removed.";
        }
        else
            return "Dog with id " + id + " not found.";
    }

    @Override
    public Dog getDogByName(String name) {
        return this.repo.findByNameIgnoreCase(name);
    }
}

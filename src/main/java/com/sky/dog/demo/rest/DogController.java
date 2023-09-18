package com.sky.dog.demo.rest;

import com.sky.dog.demo.domain.Dog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

@RestController
public class DogController {

    private final List<Dog> dogs = new ArrayList<>();

    @GetMapping("/hello") // 'maps' this method to a GET request at /hello
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/helloyou")
    public String helloYou(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/create")
    public ResponseEntity<Dog> createDog(@RequestBody Dog d) {
        dogs.add(d);
        return new ResponseEntity<>(this.dogs.get(this.dogs.size() - 1), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable int id) {

        if (id >= 0 && id < dogs.size()) {
            return new ResponseEntity<>(dogs.get(id), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public List<Dog> getAllDogs() {
        return dogs;
    }

    @PatchMapping("/update")
    public ResponseEntity<Dog> updateDog(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "breed", required = false) String breed
    ){
        if (id < 0 || id >= dogs.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (name != null) {
            dogs.get(id).setName(name);
        }
        if (age != null) {
            dogs.get(id).setAge(age);
        }
        if (colour != null) {
            dogs.get(id).setColor(colour);
        }
        if (breed != null) {
            dogs.get(id).setBreed(breed);
        }
        return new ResponseEntity<>(dogs.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Dog> removeDog(@PathVariable int id){
        if (id >= 0 && id < dogs.size()) {
            dogs.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

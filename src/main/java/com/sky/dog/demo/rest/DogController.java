package com.sky.dog.demo.rest;

import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.dtos.DogDTO;
import com.sky.dog.demo.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    //@Autowired == also valid but less intuitive than a constructor
    private final DogService service;

    //Spring automatically injects this when it boots
    public DogController(DogService service) {  //can use @Autowired but as it is the only constructor you don't need it
        this.service = service;
    }

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
        return new ResponseEntity<>(this.service.createDog(d), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DogDTO> getDog(@PathVariable int id) {
        DogDTO found = this.service.getDog(id);
        if (found != null) {
            return new ResponseEntity<>(found, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getall")
    public List<DogDTO> getAllDogs() {
        return this.service.getAllDogs();
    }

    @PatchMapping("/update")
    public ResponseEntity<DogDTO> updateDog(
            @RequestParam(name = "id") int id,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "colour", required = false) String colour,
            @RequestParam(name = "breed", required = false) String breed
    ){
        DogDTO updated = this.service.updateDog(id, name, age, colour, breed);
        if (updated == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeDog(@PathVariable int id){
        String output = this.service.removeDog(id);
        if (output.contains("removed"))
            return new ResponseEntity<>(output, HttpStatus.OK);
        else
            return new ResponseEntity<>(output, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<DogDTO> getDogByName(@PathVariable String name){
        DogDTO found = this.service.getDogByName(name);
        if (found != null)
            return new ResponseEntity<>(found, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

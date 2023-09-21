package com.sky.dog.demo.rest;


import com.sky.dog.demo.domain.Toy;
import com.sky.dog.demo.dtos.ToyDTO;
import com.sky.dog.demo.services.ToyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toy")
public class ToyController {

    private final ToyService service;

    public ToyController(ToyService toyService) {
        this.service = toyService;
    }

    @PostMapping("/create")
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        return new ResponseEntity<>(service.createToy(toy), HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public List<ToyDTO> getAllToys() {
        return this.service.getToys();
    }
}

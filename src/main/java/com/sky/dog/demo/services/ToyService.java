package com.sky.dog.demo.services;

import com.sky.dog.demo.domain.Toy;
import com.sky.dog.demo.dtos.ToyDTO;
import com.sky.dog.demo.repo.ToyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToyService {

    private final ToyRepo repo;

    public ToyService(ToyRepo repo) {
        this.repo = repo;
    }

    public Toy createToy(Toy toy) {
        return this.repo.save(toy);
    }

    public List<ToyDTO> getToys() {
        List<ToyDTO> dtos = new ArrayList<>();
        for (Toy t : this.repo.findAll())
            dtos.add(new ToyDTO(t));
        return dtos;
    }
}

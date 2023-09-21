package com.sky.dog.demo.dtos;

import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.domain.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogDTO {
    private final int id;
    private final String name;
    private final int age;
    private final String colour;
    private final String breed;
    private final List<ToyDTO> toys;

    public DogDTO(Dog d) {
        super();
        this.id = d.getId();
        this.name = d.getName();
        this.age = d.getAge();
        this.colour = d.getColour();
        this.breed = d.getBreed();
        List<ToyDTO> dtos = new ArrayList<>();
        if (d.getToys() != null) {
            for (Toy t : d.getToys())
                dtos.add(new ToyDTO(t));
        }
        this.toys = dtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DogDTO dogDTO = (DogDTO) o;
        return id == dogDTO.id && age == dogDTO.age && Objects.equals(name, dogDTO.name) && Objects.equals(colour, dogDTO.colour) && Objects.equals(breed, dogDTO.breed) && Objects.equals(toys, dogDTO.toys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, colour, breed, toys);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColour() {
        return colour;
    }

    public String getBreed() {
        return breed;
    }

    public List<ToyDTO> getToys() {
        return toys;
    }
}

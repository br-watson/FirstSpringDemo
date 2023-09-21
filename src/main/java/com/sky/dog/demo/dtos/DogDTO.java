package com.sky.dog.demo.dtos;

import com.sky.dog.demo.domain.Dog;
import com.sky.dog.demo.domain.Toy;

import java.util.ArrayList;
import java.util.List;

public class DogDTO {
    private int id;
    private String name;
    private int age;
    private String colour;
    private String breed;
    private List<ToyDTO> toys;

    public DogDTO(Dog d) {
        super();
        this.id = d.getId();
        this.name = d.getName();
        this.age = d.getAge();
        this.colour = d.getColour();
        this.breed = d.getBreed();
        List<ToyDTO> dtos = new ArrayList<>();
        for (Toy t : d.getToys())
            dtos.add(new ToyDTO(t));
        this.toys = dtos;
    }

    public DogDTO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public List<ToyDTO> getToys() {
        return toys;
    }

    public void setToys(List<ToyDTO> toys) {
        this.toys = toys;
    }
}

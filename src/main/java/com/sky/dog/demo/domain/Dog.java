package com.sky.dog.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity //tells Spring that this class is linked to a table
public class Dog {
    @Id //marks field as primary key (unique identifier)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sets the field to auto increment (id starts at 1, goes up by 1 each time)
    private Integer id;

    private String name;
    private int age;
    private String colour;
    private String breed;

    @OneToMany(mappedBy = "owner")
    private List<Toy> toys;

    public Dog(String name, int age, String colour, String breed) {
        super();
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.breed = breed;
    }

    public Dog(Integer id, String name, int age, String colour, String breed) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.breed = breed;
    }

    public Dog() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return age == dog.age && Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(colour, dog.colour) && Objects.equals(breed, dog.breed) && Objects.equals(toys, dog.toys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, colour, breed, toys);
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}

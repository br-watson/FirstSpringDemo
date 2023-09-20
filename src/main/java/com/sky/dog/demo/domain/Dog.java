package com.sky.dog.demo.domain;

import javax.persistence.*;

@Entity //tells Spring that this class is linked to a table
public class Dog {
    @Id //marks field as primary key (unique identifier)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sets the field to auto increment (id starts at 1, goes up by 1 each time)
    private Integer id;

    private String name;
    private int age;
    private String colour;
    private String breed;

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

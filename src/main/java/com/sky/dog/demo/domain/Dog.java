package com.sky.dog.demo.domain;

public class Dog {
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

    public Dog() {
        super();
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

    public String getColor() {
        return colour;
    }

    public void setColor(String colour) {
        this.colour = colour;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

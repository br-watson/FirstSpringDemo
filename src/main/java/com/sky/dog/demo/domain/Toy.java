package com.sky.dog.demo.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String shape;
    private String colour;

    @ManyToOne //unidirectional relationship
    private Dog owner;

    public Toy() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Objects.equals(id, toy.id) && Objects.equals(shape, toy.shape) && Objects.equals(colour, toy.colour) && Objects.equals(owner, toy.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shape, colour, owner);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Dog getOwner() {
        return owner;
    }

    public void setOwner(Dog owner) {
        this.owner = owner;
    }
}

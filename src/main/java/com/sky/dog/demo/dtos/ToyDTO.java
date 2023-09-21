package com.sky.dog.demo.dtos;

import com.sky.dog.demo.domain.Toy;

public class ToyDTO {
    private int id;
    private String shape;
    private String colour;
    private Integer ownerId;

    public ToyDTO(Toy toy) {
        super();
        this.id = toy.getId();
        this.shape = toy.getShape();
        this.colour = toy.getColour();
        if (toy.getOwner() != null)
            this.ownerId = toy.getOwner().getId();
    }

    public ToyDTO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}

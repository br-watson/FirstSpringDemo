package com.sky.dog.demo.dtos;

import com.sky.dog.demo.domain.Toy;

import java.util.Objects;

public class ToyDTO {
    private final int id;
    private final String shape;
    private final String colour;
    private final Integer ownerId;

    public ToyDTO(Toy toy) {
        super();
        this.id = toy.getId();
        this.shape = toy.getShape();
        this.colour = toy.getColour();
        if (toy.getOwner() != null)
            this.ownerId = toy.getOwner().getId();
        else
            this.ownerId = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToyDTO toyDTO = (ToyDTO) o;
        return id == toyDTO.id && Objects.equals(shape, toyDTO.shape) && Objects.equals(colour, toyDTO.colour) && Objects.equals(ownerId, toyDTO.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shape, colour, ownerId);
    }

    public int getId() {
        return id;
    }


    public String getShape() {
        return shape;
    }

    public String getColour() {
        return colour;
    }

    public Integer getOwnerId() {
        return ownerId;
    }
}

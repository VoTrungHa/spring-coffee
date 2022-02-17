package com.coffee.coffee.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank(message = "Size  is required ")
    private String Size;

    @NotBlank(message = "Size  is required ")
    private Double price;

    public Attribute(Double price) {
        this.price = price;
    }
    public Attribute(){}

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

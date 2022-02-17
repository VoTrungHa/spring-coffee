package com.coffee.coffee.Models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @NotBlank(message = "Name  is required ")
    private String Name;
    @NotBlank(message = "Image  is required ")
    private String Image;
    @NotBlank(message = "Category  is required ")
    private String Category;
    @NotBlank(message = "Attribute  is required ")
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

}

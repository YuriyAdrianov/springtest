package ru.yuriy.springtest.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Product {
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters!")
    private String name;

    @NotEmpty(message = "Name should not be empty!")
    @Min(value = 0, message = "Price should be greater than 0!")
    private int price;

    private String description;

    private String creationDate;

    private String modificationDate;

    public Product() {
        // empty constructor
    }

    public Product(int id, String name, int price, String description, String creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.creationDate = creationDate;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
}

package com.example.springcrudof.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    
    
    private Long id;
    private String name;
    private float price;
    private String supplier;

    // Default constructor
    public Product() {
    }

    public Product(Long id, String name, float price, String supplier) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    // toString method
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", supplier=" + supplier + "]";
    }
}

package com.companyname.springapp.business.entities;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;
    private Double price;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    private static final long serialVersionUID = 1L;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Description: ").append(description).append("; ");
        buffer.append("Price: ").append(price);
        return buffer.toString();
    }
}

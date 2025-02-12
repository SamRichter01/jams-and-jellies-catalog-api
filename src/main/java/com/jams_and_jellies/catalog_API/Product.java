package com.jams_and_jellies.catalog_API;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
class Product {
    
    @Id @GeneratedValue
    private Integer id;

    private String name;

    Product(String name) {
        this.name = name;
    }

    Product() {}
}
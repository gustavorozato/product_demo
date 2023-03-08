package com.example.spring_demo.model;

import com.example.spring_demo.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="product_seq")
    @SequenceGenerator(name="product_seq", sequenceName="product_seq")
    private long id;

    private String model;
    private String description;
    @Transient
    private boolean isModelNew;

    public boolean isModelNew() {
        if (model == null) return false;
        return model.equals("2023");
    }
}

package com.jenncode.overstock_markdown_inventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//below ive called my getting and setter using lombok

    private long id;

    private String name;

    private int currentQuantity;

    private int minThreshold;

    private int maxThreshold;

    private Date expiryDate;

    private Date markdownDate;

    private int displayedQuantity;


    //below is my constructor
    public Product(String name, int currentQuantity, int minThreshold, int maxThreshold, Date expiryDate, Date markdownDate) {
        this.name = name;
        this.currentQuantity = currentQuantity;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.expiryDate = expiryDate;
        this.markdownDate = markdownDate;
    }
}

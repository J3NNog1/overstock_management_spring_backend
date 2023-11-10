package com.jenncode.overstock_markdown_inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String message;

    private LocalDateTime timestamp;

    // Constructors, getters, and setters

    // Default constructor for JPA
    public Notification() {
    }

    public Notification(String productName, String message, LocalDateTime timestamp) {
        this.productName = productName;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and setters...
}


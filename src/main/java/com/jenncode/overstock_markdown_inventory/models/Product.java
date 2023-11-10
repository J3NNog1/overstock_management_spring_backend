package com.jenncode.overstock_markdown_inventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Scanner;


import static org.apache.tomcat.util.http.FastHttpDateFormat.parseDate;

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
    public Product(Scanner scanner) {
        System.out.print("Enter product name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter current quantity: ");
        this.currentQuantity = scanner.nextInt();

        System.out.print("Enter minimum quantity: ");
        this.minThreshold = scanner.nextInt();

        System.out.print("Enter maximum quantity: ");
        this.maxThreshold = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter expiry date (yyyy-MM-dd): ");
        String expiryDateString = scanner.nextLine();
        this.expiryDate = parseDate(expiryDateString);

        System.out.print("Enter markdown date (yyyy-MM-dd): ");
        String markdownDateString = scanner.nextLine();
        this.markdownDate = parseDate(markdownDateString);

        System.out.print("Displayed quantity is: ");
        this.displayedQuantity = scanner.nextInt();

        scanner.nextLine();

        // Print entered values for debugging
        System.out.println("Entered values:");
        System.out.println("Name: " + this.name);
        System.out.println("Current Quantity: " + this.currentQuantity);
        System.out.println("Min Threshold: " + this.minThreshold);
        System.out.println("Max Threshold: " + this.maxThreshold);
        System.out.println("Expiry Date: " + this.expiryDate);
        System.out.println("Markdown Date: " + this.markdownDate);
        System.out.println("Displayed Quantity: " + this.displayedQuantity);

    }
    // Helper method to parse date from string
    private Date parseDate(String dateString) {
        // Implement your date parsing logic here
        return null;  // Replace this with the actual logic
    }



    // Method to check if the product quantity is below the threshold
    public boolean isBelowThreshold() {
        return currentQuantity < minThreshold;
    }

    // Method to check if the product quantity is above the threshold
    public boolean isAboveThreshold() {
        return currentQuantity > maxThreshold;
    }

}


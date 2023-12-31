package com.jenncode.overstock_markdown_inventory.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
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
        try {
            LocalDate localDate = LocalDate.parse(dateString);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            // Handle parsing exception
            e.printStackTrace(); // For demonstration purposes, you might want to handle this more gracefully in your actual application
            return null;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", minThreshold=" + minThreshold +
                ", maxThreshold=" + maxThreshold +
                ", expiryDate=" + expiryDate +
                ", markdownDate=" + markdownDate +
                ", displayedQuantity=" + displayedQuantity +
                '}';
    }

    // Method to check if the product quantity is below the threshold
    public boolean isBelowThreshold() {
        return currentQuantity < minThreshold;
    }

    // Method to check if the product quantity is above the threshold
    public boolean isAboveThreshold() {
        return currentQuantity > maxThreshold;
    }

    // Check if the product has reached its expiry date
    public boolean hasExpired() {
        Date currentDate = new Date();
        return currentDate.after(expiryDate);
    }
    public boolean needsMarkdown() {
        Date currentDate = new Date();
        return currentDate.after(markdownDate);
    }
    // Calculate the Markdown Date
    public void calculateMarkdownDate() {
        // Assuming expiryDate is set and not null
        long timeDifference = expiryDate.getTime() - new Date().getTime();
        long daysDifference = timeDifference / (1000 * 60 * 60 * 24); // Convert milliseconds to days
        markdownDate = new Date(new Date().getTime() + daysDifference);
    }

    // Send Notification for Markdown
    public void sendMarkdownNotification() {
        if (needsMarkdown()) {
            System.out.println("Notification: Product " + name + " needs to be marked down!");
        }
    }

}


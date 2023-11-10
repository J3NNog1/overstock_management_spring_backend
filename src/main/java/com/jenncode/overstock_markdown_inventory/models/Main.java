package com.jenncode.overstock_markdown_inventory.models;

import com.jenncode.overstock_markdown_inventory.service.ProductService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Product product = new Product(scanner);

            // Create ProductService instance
            ProductService productService = new ProductService();


            // Check and notify quantity thresholds
            productService.checkAndNotifyQuantityThreshold(product);

            // Update product quantity (for demonstration purposes)
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            productService.updateProductQuantity(product, newQuantity);

            // Print updated product information
            System.out.println("Updated Product Information:");
            System.out.println(product);
        }
    }
}
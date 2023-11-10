package com.jenncode.overstock_markdown_inventory.service;

import com.jenncode.overstock_markdown_inventory.models.Product;

import java.time.LocalDateTime;

public class ProductService {
    public void checkAndNotifyQuantityThreshold(Product product) {
        if (product != null) {
            if (product.getCurrentQuantity() <= product.getMinThreshold() ||
                    product.getCurrentQuantity() >= product.getMaxThreshold()) {
                // Send notification
                String notificationMessage = "Quantity threshold reached for product: " + product.getName();
                System.out.println(notificationMessage);

                // Store information in the database with timestamp
                storeNotificationInDatabase(product, notificationMessage, LocalDateTime.now());
            }
        }
    }

    private void storeNotificationInDatabase(Product product, String notificationMessage, LocalDateTime timestamp) {
        // Implement database storage logic here
        // For simplicity, let's just print the information for demonstration purposes
        System.out.println("Storing in database: Product - " + product.getName() +
                ", Notification - " + notificationMessage +
                ", Timestamp - " + timestamp);
    }

    public void updateProductQuantity(Product product, int newQuantity) {
        if (product != null) {
            product.setCurrentQuantity(newQuantity);
        }
    }
}

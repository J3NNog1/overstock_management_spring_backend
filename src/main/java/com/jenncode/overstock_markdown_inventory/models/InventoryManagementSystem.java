package com.jenncode.overstock_markdown_inventory.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InventoryManagementSystem {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void checkInventory() {
        for (Product product : products) {
            if (product.isBelowThreshold() || product.isAboveThreshold()) {
                System.out.println("Notification: Replenish " + product.getName() + " at " + new Date());
                // Store in the database with timestamp
            }

            if (product.hasExpired()) {
                System.out.println("Notification: " + product.getName() + " has expired. Quantity: " + product.getCurrentQuantity() + " at " + new Date());
                // Store in the database with timestamp
            }

            if (product.needsMarkdown()) {
                System.out.println("Notification: Mark down " + product.getName() + " at " + new Date());
                // Store in the database with timestamp
            }
        }
    }
}

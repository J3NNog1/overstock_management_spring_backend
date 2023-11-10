package com.jenncode.overstock_markdown_inventory.service;

import com.jenncode.overstock_markdown_inventory.models.Product;

public class ProductService {

        public void checkAndNotifyQuantityThreshold(Product product) {
            if (product != null) {
                if (product.getCurrentQuantity() <= product.getMinThreshold() ||
                        product.getCurrentQuantity() >= product.getMaxThreshold()) {
                    // Send notification
                    String notificationMessage = "Quantity threshold reached for product: " + product.getName();
                    System.out.println(notificationMessage);
                }
            }
        }

        public void updateProductQuantity(Product product, int newQuantity) {
            if (product != null) {
                product.setCurrentQuantity(newQuantity);
            }
        }

}

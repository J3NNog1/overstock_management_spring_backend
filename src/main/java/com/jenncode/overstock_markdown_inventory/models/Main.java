package com.jenncode.overstock_markdown_inventory.models;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Product product = new Product(scanner);
            // Handle the product as needed
        }

    }
}
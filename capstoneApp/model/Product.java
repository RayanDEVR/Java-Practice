package capstoneApp.model;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private final int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stok) {

        if (id <= 0) {
            throw new IllegalArgumentException("Invalid product ID.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }

        if (stok <= 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stok;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void update(String name, double price) {
        if (name == null || name.isBlank() || price <= 0) {
            throw new IllegalArgumentException("Invalid product update.");
        }

        this.name = name;
        this.price = price;
    }

    public void addStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Stock must be positive.");
        }

        stock += quantity;
    }

    public void reduceStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock.");
        }

        stock -= quantity;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Product other)) {
            return false;
        }

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Price: " + price + " | Stock: " + stock;
    }
}

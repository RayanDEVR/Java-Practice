/*
Inventory Management System [Mini Project | Project]
Model Product and StockMovement with movement enum. InventoryService uses Map by SKU, validates stock-
in/out and tracks movements. Add Comparator and stream reports.
Done when: Duplicate SKU is rejected, stock never becomes negative, and reports include low stock, sorted 
catalogue and total inventory value.
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum MovementType {
    In, Out
}

class Product {
    String sku;
    String name;
    double price;
    int stock;
    
    Product(String sku, String name, double price, int stock) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class StockMovement {
    String sku;
    MovementType type;
    int quantity;
    
    StockMovement(String sku, MovementType type, int quantity) {
        this.sku = sku;
        this.type = type;
        this.quantity = quantity;
    }
}

class InventoryService {
    Map<String, Product> products = new HashMap<>();
    List<StockMovement> movements = new ArrayList<>();
    
    void addProduct(Product product) {
        if (products.containsKey(product.sku)) {
            System.out.println("Duplicate SKU: " + product.sku + " found.");
            return;
        }
        
        products.put(product.sku, product);
    }
    
    void stockIn(String sku, int quantity) {
        Product product = products.get(sku);
        
        if (product == null) {
            System.out.println("Product fot found.");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Invalid quantity: " + quantity);
        }
        
        product.stock += quantity;
        movements.add(new StockMovement(sku, MovementType.In, quantity));
    }
    
    void stockOut(String sku, int quantity) {
        Product product = products.get(sku);
        
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Invalid quantity: " + quantity);
            return;
        }
        
        if (quantity > product.stock) {
            System.out.println("Insufficient stock. Available stock: " + product.stock);
            return;
        }
        
        product.stock -= quantity;
        movements.add(new StockMovement(sku, MovementType.Out, quantity));
    }
    
    void showLowStock(int limit) {
        System.out.println("\nLow Stock: ");
        
        products.values()
                .stream()
                .filter(p -> p.stock <= limit)
                .forEach(p -> System.out.println("SKU: " + p.sku + " | Name: " + p.name + " | Stock: " + p.stock));
    }
    
    void showSortedProducts() {
        System.out.println("\nSorted Catalogue: ");
        
        products.values()
                .stream()
                .sorted(Comparator.comparingDouble(p -> p.price))
                .forEach(p -> System.out.println("SKU: " + p.sku + " | Name: " + p.name + " | Price: " + p.price + " | Stock: " + p.stock));
    }
    
    void totalInventoryValue() {
        double total = products.values()
                               .stream()
                               .mapToDouble(p -> p.price * p.stock)
                               .sum();
        
        System.out.println("\nTotal Inventory Value: " + total);
    }
}

public class Ex192InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        
        service.addProduct(new Product("P-101", "Mouse", 150, 10));
        service.addProduct(new Product("P-102", "Keyboard", 800, 5));
        service.addProduct(new Product("P-103", "Monitor", 15000, 1));
        service.addProduct(new Product("P-102", "Printer", 8000, 10));
        
        service.stockIn("P-102", 5);
        service.showSortedProducts();
        
        service.stockOut("P-101", 8);
        service.showSortedProducts();
        
        service.showLowStock(5);
        
        service.totalInventoryValue();
    }
}
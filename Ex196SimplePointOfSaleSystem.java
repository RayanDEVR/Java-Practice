/*
Simple Point-of-Sale System [Mini Project | Project]
Combine product catalogue Map, cart lines List, stock validation, payment interface, receipt builder and cashier 
menu. Apply one pluggable discount policy.
Done when: Checkout is failure-atomic: stock decreases only after all validation/payment simulation succeeds; 
receipt and end-of-day totals reconcile.
*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Payment {
    boolean pay(double amount);
}

interface DiscountPolicy {
    double getDiscount(double amount);
}

class Product {
    int id;
    String name;
    double price;
    int stock;
    
    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class CartItem {
    Product product;
    int quantity;
    
    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    double getTotal() {
        return product.price * quantity;
    }
}

class CashPayment implements Payment {
    public boolean pay(double amount) {
        System.out.println("Cash payment successful: " + amount);
        return true;
    }
}

class TenPercentDiscount implements DiscountPolicy {
    public double getDiscount(double amount) {
        return amount * 0.10;
    }
}

class POSService {
    Map<Integer, Product> products = new HashMap<>();
    List<CartItem> cart = new ArrayList<>();
    
    void addProduct(Product product) {
        products.put(product.id, product);
    }
    
    void addToCart(int productId, int quantity) {
        Product product = products.get(productId);
        
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        if (quantity <= 0 || quantity > product.stock) {
            System.out.println("Invalid quantity or insufficient stock.");
            return;
        }
        
        cart.add(new CartItem(product, quantity));
    }
    
    double calculateSubtotal() {
        double total = 0;
        
        for (CartItem item: cart) {
            total += item.getTotal();
        }
        
        return total;
    }
    
    void checkout(Payment payment, DiscountPolicy discountPolicy) {
        for (CartItem item: cart) {
            if (item.quantity > item.product.stock) {
                System.out.println("Insufficient stock.");
                return;
            }
        }
            
            double subtotal = calculateSubtotal();
            double discount = discountPolicy.getDiscount(subtotal);
            double finalTotal = subtotal - discount;
            
            if (!payment.pay(finalTotal)) {
                System.out.println("Payment failed.");
                return;
            }
            
            for (CartItem item: cart) {
                item.product.stock -= item.quantity;
            }
            
            System.out.println("Reciept:");
            
            for (CartItem item: cart) {
                System.out.println(item.product.name + " X " + item.quantity + " = " + item.getTotal());
            }
            
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Discount: " + discount);
            System.out.println("Final Total: " + finalTotal);
            
            System.out.println("Checkout successful.");
            
            cart.clear();
    }
}

public class Ex196SimplePointOfSaleSystem {
    public static void main(String[] args) {
        POSService pos = new POSService();
        
        pos.addProduct(new Product(1, "Keyboard", 1000, 10));
        pos.addProduct(new Product(2, "Mouse", 800, 7));
        pos.addProduct(new Product(3, "Monitor", 15000, 5));
        
        pos.addToCart(1, 2);
        pos.addToCart(3, 1);
        
        pos.checkout(new CashPayment(), new TenPercentDiscount());
    }
}
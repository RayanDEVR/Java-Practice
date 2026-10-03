/*
Shopping Cart Domain [Mini Project | Project]
Build Product, CartItem, Cart, Customer, Order and CheckoutService without UI first. Implement 
add/update/remove item, subtotal, discount, checkout and order status.
Done when: Cart merges or deliberately preserves duplicate products according to a documented rule; 
quantity/stock validation and reports are correct.
*/


import java.util.ArrayList;
import java.util.List;

enum OrderStatus {
    Created, Confirmed, Cancelled
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

class Cart {
    List<CartItem> items = new ArrayList<>();
    
    void addItem(Product product, int quantity) {
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }
        
        if (quantity > product.stock) {
            System.out.println("Not enough stock for " + product.name);
            return;
        }
        
        for (CartItem item: items) {
            if (item.product.id == product.id) {
                if (item.quantity + quantity > product.stock) {
                    System.out.println("Not enough stock for " + item.product.name);
                    return;
                }
                
                item.quantity += quantity;
                System.out.println("Product quantity updated.");
                return;
            }
        }
        
        items.add(new CartItem(product, quantity));
        System.out.println("Product added.");
    }
    
    void updateQuantity(int productId, int quantity) {
        
        for (CartItem item: items) {
            
            if (item.product.id == productId) {
                if (quantity <= 0) {
                    System.out.println("Invalid quantity.");
                    return;
                }
                
                if (quantity > item.product.stock) {
                    System.out.println("Not enough stock for " + item.product.name);
                    return;
                }
                
                item.quantity = quantity;
                System.out.println("Quantity updated.");
                return;
            }
        }
        
        System.out.println("Product not found.");
    }
    
    void removeItem(int productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).product.id == productId) {
                items.remove(i);
                System.out.println("Product removed.");
                return;
            }
        }
        
        System.out.println("Product not found.");
    }
    
    double getSubtotal() {
        double total = 0;
        for (CartItem item: items) {
            total += item.getTotal();
        }
        
        return total;
    }
    
    void showCart() {
        System.out.println("\nCart:");
        
        for (CartItem item: items) {
            System.out.println(item.product.name + " X " + item.quantity + " = " + item.getTotal());
        }
        
        System.out.println("Subtotal: " + getSubtotal());
    }
}

class Customer {
    int id;
    String name;
    Cart cart;
    
    Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.cart = new Cart();
    }
}

class Order {
    int id;
    Customer customer;
    double total;
    OrderStatus status;
    
    Order(int id, Customer customer, double total) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.status = OrderStatus.Confirmed;
    }
}

class CheckoutService {
    int nextOrderId = 1;
    
    Order checkout(Customer customer, double discountInPercent) {
        
        for (CartItem item: customer.cart.items) {
            if (item.quantity > item.product.stock) {
                System.out.println("Not enough stock for " + item.product.name);
                return null;
            }
        }
        
        double subtotal = customer.cart.getSubtotal();
        double discount = subtotal * (discountInPercent / 100);
        double finalTotal = subtotal - discount;
        
        System.out.println("\nOrder ID: " + nextOrderId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Final Total: " + finalTotal);
        
        Order order = new Order(nextOrderId, customer, finalTotal);
        
        nextOrderId++;
        
        for (CartItem item: customer.cart.items) {
            item.product.stock -= item.quantity;
        }
        
        customer.cart.items.clear();
        
        return order;
    }
}

public class Ex197ShoppingCartDomain {
    public static void main(String[] args) {
        Product mouse = new Product(1, "Mouse", 800, 10);
        Product keyboard = new Product(2, "Keyboard", 1000, 8);
        
        Customer c1 = new Customer(101, "Rayan");
        Customer c2 = new Customer(102, "Samiul");
        
        CheckoutService service = new CheckoutService();
        
        c1.cart.addItem(mouse, 2);
        c1.cart.addItem(mouse, 3);
        c1.cart.showCart();
        
        Order order1 = service.checkout(c1, 10);
        System.out.println();
        
        
        c2.cart.addItem(mouse, 6);
        c2.cart.addItem(keyboard, 1);
        c2.cart.showCart();
        
        Order order2 = service.checkout(c2, 5);
    }
}
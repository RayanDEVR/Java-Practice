/*
Restaurant Ordering System [Mini Project | Project]
Model MenuItem, OrderItem, Order, Table and OrderStatus. Use Map for menu lookup, List for lines and a 
DiscountPolicy lambda for offers. Produce an itemized receipt.
Done when: Enforce positive quantities, known menu IDs, valid status transitions and correct 
subtotal/tax/discount/final total.
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

enum OrderStatus {
    NEW, CONFIRMED, SERVED, CANCELLED
}

class MenuItem {
    int id;
    String name;
    double price;
    
    MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    MenuItem item;
    int quantity;
    
    OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    double getTotal() {
        return item.price * quantity;
    }
}

class Table {
    int tableNumber;
    
    Table(int tableNumber) {
        this.tableNumber = tableNumber;
    }
}

class Order {
    int id;
    Table table;
    List<OrderItem> items = new ArrayList<>();
    OrderStatus status = OrderStatus.NEW;
    
    Order(int id, Table table) {
        this.id = id;
        this.table = table;
    }
    
    void addItem(MenuItem item, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        
        items.add(new OrderItem(item, quantity));
    }
    
    double getSubtotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
}

interface DiscountPolicy {
    double getDiscount(double subTotal);
}

class RestaurantService {
    Map<Integer, MenuItem> menu = new HashMap<>();
    
    void addMenuItem(MenuItem item) {
        menu.put(item.id, item);
    }
    
    void addItemToOrder(Order order, int menuId, int quantity) {
        MenuItem item = menu.get(menuId);
        
        if (item == null) {
            System.out.println("Menu item not found.");
            return;
        }
        
        order.addItem(item, quantity);
    }
    
    void changeStatus(Order order, OrderStatus status) {
        order.status = status;
    }
    
    void printReceipt(Order order, DiscountPolicy policy) {
        double subtotal = order.getSubtotal();
        double discount = policy.getDiscount(subtotal);
        double tax = (subtotal - discount) * 0.10;
        double finalTotal = (subtotal - discount) + tax;
        
        System.out.println("\n--- Receipt ---");
        
        for (OrderItem item : order.items) {
            System.out.println(item.item.name + " X " + item.quantity + " = " + item.getTotal());
        }
        
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Total: " + finalTotal);
        
    }
}

public class Ex188RestaurantOrderingSystem {
    public static void main(String[] args) {
        RestaurantService restaurant = new RestaurantService();
        
        restaurant.addMenuItem(new MenuItem(1, "Burger", 300));
        restaurant.addMenuItem(new MenuItem(2, "Coffee", 50));
        restaurant.addMenuItem(new MenuItem(3, "Pizza", 800));
        
        Table table = new Table(5);
        Order order = new Order(101, table);
        
        restaurant.addItemToOrder(order, 1, 2);
        restaurant.addItemToOrder(order, 2, 1);
        restaurant.addItemToOrder(order, 3, 2);
        
        restaurant.changeStatus(order, OrderStatus.CONFIRMED);
        
        DiscountPolicy discount = subtotal -> subtotal >= 1000 ?subtotal * 0.10 :0;
        
        restaurant.printReceipt(order, discount);
    }
}
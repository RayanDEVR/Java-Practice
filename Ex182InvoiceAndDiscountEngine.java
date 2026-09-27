import java.util.*;

enum CustomerType {
    REGULAR, MEMBER, VIP
}

@FunctionalInterface
interface DiscountPolicy {
    double applyDiscount(double subtotal, CustomerType type);
}

class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class InvoiceLine {
    Product product;
    int quantity;
    InvoiceLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    double subtotal() {
       return product.price * quantity;
    }
}

class InvoiceService implements DiscountPolicy {
    final double tax = 0.1;
    
    @Override
    public double applyDiscount(double subtotal, CustomerType type) {
        return switch(type) {
            case REGULAR -> subtotal * 0.05;
            case MEMBER -> subtotal * 0.10;
            case VIP -> subtotal * 0.15;
        };
    }
    
    double calculateTax(double subtotal, double discount) {
        return (subtotal - discount)* tax;
    }
    
    double finalTotal(double subtotal, double discount) {
        double calculateDiscount = discount;
        double calculateTax = (subtotal - calculateDiscount) * tax;
        return (subtotal - calculateDiscount) + calculateTax;
    }
}

public class Ex182InvoiceAndDiscountEngine {
    
    public static void main(String[] args) {
        List<InvoiceLine> lines = new ArrayList<>();
        lines.add(new InvoiceLine(new Product("Pen", 10), 6));
        lines.add(new InvoiceLine(new Product("Notebook", 50), 5));
        lines.add(new InvoiceLine(new Product("Pencil", 5), 10));
        
        double subtotal = 0;
        
        for (InvoiceLine invoice: lines) {
            subtotal += invoice.subtotal();
        }
        
        InvoiceService service = new InvoiceService();
        
        double discount = service.applyDiscount(subtotal, CustomerType.MEMBER);
        double tax = service.calculateTax(subtotal, discount);
        double total = service.finalTotal(subtotal, discount);
        
        System.out.println("Subtotal: " + subtotal );
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Total: " + total);
    }
    
}
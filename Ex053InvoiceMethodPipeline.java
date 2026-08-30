/*
Invoice Method Pipeline   [Refactoring | Intermediate]
Split one long invoice program into calculateSubtotal, calculateDiscount, calculateTax and calculateFinalTotal. 
Make data flow through return values.
Done when: main reads like a sequence of business steps and no formula is duplicated.
 */

class Calculate {
    public double calculateSubtotal(double price1, double price2) {
        return price1 + price2;
    }

    public double calculateDiscount(double subtotal) {
        return subtotal * 0.1;
    }

    public double calculateTax(double subtotal) {
        return subtotal * 0.05;
    }

    public double calculateFinalTotal(double subtotal, double discount, double tax) {
        return (subtotal - discount) + tax;
    }
        
}

public class Ex53invoiceMethodPipeline {
    public static void main(String[] args) {
        Calculate bill = new Calculate();        
        double subtotal = bill.calculateSubtotal(1200, 1500);
        double discount = bill.calculateDiscount(subtotal);
        double tax = bill.calculateTax(subtotal);
        double finalTotal = bill.calculateFinalTotal(subtotal, discount, tax);

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " +  tax);
        System.out.println("Final Total: " + finalTotal);
    }
}

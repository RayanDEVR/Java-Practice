/*
Order Summary Coordinator   [Scenario-Based | Intermediate]
Create a method that coordinates validation, subtotal, discount, tax and final total by calling focused helpers. It 
should return the final total and print no prompts.
Done when: The coordinator contains almost no arithmetic and invalid input is handled consistently. 
*/

class Coordinator{
    public boolean isValidOrder(int quantity, double unitPrice) {       //validation
        return quantity > 0 && unitPrice > 0;
    }

    public double calculateSubtotal(int quantity, double unitPrice) {       //subtotal
        return quantity * unitPrice;
    }
    
    public double calculateDiscount(double subtotal, double discountPercent) {      //discount
        return (subtotal * discountPercent) / 100;
    }

    public double calculateTax(double subtotal, double taxPercent) {        //tax
        return (subtotal * taxPercent) / 100;
    }

    public double finalTotal(double subtotal, double discount, double tax) {        //final total
        return (subtotal - discount) + tax;
    }
}

public class Ex065OrderSummaryCoordinator {
    public static void main(String[] args) {
        Coordinator odr = new Coordinator();

        double subtotal = odr.calculateSubtotal(10, 25);
        double discount = odr.calculateDiscount(subtotal, 10);
        double tax = odr.calculateTax(subtotal, 5);
        double finalTotal = odr.finalTotal(subtotal, discount, tax);

        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Fianl Total: " + finalTotal);
    }
}

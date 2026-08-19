/*
First Reusable Business Method   [Build from Scratch | Intermediate]
Write calculateSubtotal(int quantity, double unitPrice) returning a double. main should only prepare data, call 
the method and print the result.
Done when: The method has no hidden input/output and works for at least four test cases.
 */

class SubtotalCalculator {
    public double calculateSubtotal(int quantity, double unitPrice) {
        return quantity + unitPrice;
    }
}

public class Ex51firstReusableBusinessMethod {
    public static void main(String[] args) {
        int quantity = 30;
        double unitPrice = 120;

        SubtotalCalculator total = new SubtotalCalculator();
        double subtotal = total.calculateSubtotal(quantity, unitPrice);

        System.out.println("SubTotal: " + subtotal);
    }
}

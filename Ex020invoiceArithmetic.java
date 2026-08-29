/*
Invoice Arithmetic   [Build from Scratch | Beginner]
Given quantity, unitPrice, taxPercent and deliveryFee, calculate subtotal, tax, pre-discount total and final total. 
Print each intermediate amount.
Done when: The formulas are correct and test cases include quantity 0, tax 0 and a normal order.
 */

public class Ex20invoiceArithmetic {
    public static void main(String[] args) {
        int quantity = 5;
        double unitPrice = 200;
        double taxPercent = (double)10/100;
        double deliveryFee = 60;


        double subtotal = quantity * unitPrice;
        double tax = subtotal * taxPercent;
        double preDiscountTotal = subtotal + tax; 
        double finalTotal = preDiscountTotal + deliveryFee;

        System.out.println(finalTotal);
    }
}

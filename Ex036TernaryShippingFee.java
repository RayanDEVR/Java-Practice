/*
Ternary Shipping Fee   [Code Completion | Beginner]
Complete a ternary expression: orders at or above a threshold receive free shipping; otherwise use a fixed fee. 
Then state when an if/else would be clearer.
Done when: Both branches are tested and the ternary remains a simple value choice.
 */

public class Ex036TernaryShippingFee {
    public static void main(String[] args) {
        double orderAmount = 800;
        double shippingFee = orderAmount >= 1000 ? 0 : 150;

        System.out.println("Shipping Fee: " + shippingFee);
    }
}

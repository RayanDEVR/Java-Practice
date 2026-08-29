/*
Customer Message Composer   [Build from Scratch | Intermediate]
Create methods that return a welcome message, payment-success message and payment-failure message. Use 
a builder when a message has several conditional pieces.
Done when: Messages are returned, not printed inside every helper, and are grammatically coherent.
*/

class Massage {
    public void welcomMassage(String customerName) {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome, ").append(customerName).append("! We're glad to have you.");
        sb.toString();
        System.out.println(sb);
    }

    public void paymentSuccessMassage(String customerName, double ammount, boolean isFirstPurchase) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi ").append(customerName).append(", your payment of $").append(ammount).append(" is successful.");
        if (isFirstPurchase)
            sb.append(" As a first-time buyer, thank you for choosing us.");
        sb.toString();
        System.out.println(sb);
    }
    
    public void paymentFailure(String customerName, String reason) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi ").append(customerName).append(", your payment could not be processed. Reason: ").append(reason);
        sb.toString();
        System.out.println(sb);
    }
}

public class Ex97CustomerMessageComposer {
    public static void main(String[] args) {
        Massage customer = new Massage();
        customer.welcomMassage("Rayan");
        customer.paymentSuccessMassage("Samiul", 500.0, true);
        customer.paymentSuccessMassage("Abdullah", 300.0, false);
        customer.paymentFailure("Anika", "Insufficient Balance.");
    }
}

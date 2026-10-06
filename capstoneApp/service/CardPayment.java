package capstoneApp.service;

public class CardPayment implements PaymentProcessor {
    private final boolean shouldSucceed;

    public CardPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override 
    public boolean pay(double amount) {
        System.out.println("Processing card payment: " + amount);

        return shouldSucceed;
    }
}

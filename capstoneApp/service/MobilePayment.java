package capstoneApp.service;

public class MobilePayment implements PaymentProcessor {
    private final boolean shouldSucceed;

    public MobilePayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override 
    public boolean pay(double amount) {
        System.out.println("Processing mobile payment: " + amount);

        return shouldSucceed;
    }
}

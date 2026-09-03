/*
Interface-Driven Payment Processor   [Scenario-Based | Advanced]
Define PaymentMethod.pay(amount) and implement CardPayment, MobileWalletPayment and CashPayment. 
CheckoutService receives a PaymentMethod rather than constructing one internally.
Done when: Changing payment method requires no modification to checkout calculation logic.
*/

interface PaymentMethod {
    void pay(double amount);
}

class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Card.");
    }
}

class MobileWalletPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Mobile Wallet.");
    }
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Cash.");
    }
}

class CheckoutService {
    public void checkout(double amount, PaymentMethod method) {
        method.pay(amount);
    }
}

public class Ex125InterfaceDrivenPaymentProcessor {
    public static void main(String[] args) {
        CheckoutService c = new CheckoutService();
        c.checkout(1200, new CardPayment());
        c.checkout(1500, new MobileWalletPayment());
        c.checkout(2000, new CashPayment());
    }
}

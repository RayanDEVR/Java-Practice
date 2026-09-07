/*
OOP Refactoring: Procedural Checkout   [Refactoring | Advanced]
A procedural checkout uses parallel arrays, a switch on paymentType, public stock fields and repeated discount 
formulas. Refactor into Product, Cart, DiscountPolicy, PaymentMethod and CheckoutService using only taught 
features.
Done when: Responsibilities are separated, fields are protected and behavior is replaceable through interfaces.
*/

interface DiscountPolicy {
    double discount(double total);
}

class RegularDiscount implements DiscountPolicy {
    @Override
    public double discount(double total) {
        return total * 0.01;
    }
}

interface PaymentMethod {
    void pay(double ammount);
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(double ammount) {
        System.out.println("Cash paid: " + ammount);
    }
}

class Product {
    private String name;
    private double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Cart {
    private Product product;

    Cart(Product product) {
        this.product = product;
    }

    public double total() {
        return product.getPrice();
    }
}

class CheckoutService {
    private DiscountPolicy discountPolicy;
    private PaymentMethod paymentMethod;

    CheckoutService(DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        this.discountPolicy = discountPolicy;
        this.paymentMethod = paymentMethod;
    }

    void checkout(Cart cart) {
        double total = cart.total();
        double payable = total - discountPolicy.discount(total);

        paymentMethod.pay(payable);
    }
}

public class Ex144OOPRefactoringProceduralCheckout {
    public static void main(String[] args) {
        Cart cart = new Cart(new Product("Mouse", 1000));
        CheckoutService checkoutService = new CheckoutService(
            new RegularDiscount(),
            new CashPayment()
            );
        checkoutService.checkout(cart);     
    }
}

/*
Complex Domain Model Review   [Code Reading | Advanced]
Review a model with Customer, PremiumCustomer, Address, Order and PaymentMethod. Label inheritance, 
composition, interface implementation and aggregation-like references, then flag one misuse.
Done when: Every relationship is justified from business meaning, not diagram aesthetics.
*/

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Customer {
    String name;
    Address address;

    Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

class PremiumCustomer extends Customer {
    int loyalPoint;

    PremiumCustomer(String name, Address address, int loyalPoint) {
        super(name, address);
        this.loyalPoint = loyalPoint;
    }
}

interface PaymentMethod {
    public void pay(double ammount);
}

class CardPayment implements PaymentMethod {
    @Override 
    public void pay(double ammount){
        System.out.println("Card paid: " + ammount);
    }
}

class Order {
    Customer customer;
    PaymentMethod paymentMethod;

    Order(Customer customer, PaymentMethod paymentMethod) {
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }
}


public class Ex143ComplexDomainModelReview {
    public static void main(String[] args) {
        Customer c = new PremiumCustomer("Rayan", new Address("Dhaka"), 250);
        Order order = new Order(c, new CardPayment());
        order.paymentMethod.pay(1500);
        System.out.println("Order placed for " + order.customer.name + " in " + ((PremiumCustomer)order.customer).address.city);
    }
}

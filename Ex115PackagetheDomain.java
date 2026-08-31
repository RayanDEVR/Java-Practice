/*
Package the Domain   [Build from Scratch | Intermediate]
Split a small project into app, model and service packages. Place Customer/Product in model and BillingService 
in service, then import them into app.
Done when: The package declarations match folders and only required types are public.
*/

import app.model.Customer;
import app.model.Product;
import app.service.BillingService;

public class Ex115PackagetheDomain {
    public static void main(String[] args) {
        Customer c = new Customer("Rayan");
        Product p = new Product("Headphones", 1000.0);
        BillingService billing = new BillingService();
        System.out.println(c.name + "'s total: " + billing.calculateTotal(p, 10));
    }
}

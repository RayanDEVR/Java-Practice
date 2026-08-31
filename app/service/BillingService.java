package app.service;
import app.model.Product;

public class BillingService {
    public double calculateTotal(Product product, int quantity) {
        return product.price * quantity;
    }
}

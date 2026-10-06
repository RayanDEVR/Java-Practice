package capstoneApp.model;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        this.quantity = quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }
}

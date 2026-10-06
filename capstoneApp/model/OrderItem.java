package capstoneApp.model;

public class OrderItem {
    private final int productId;
    private final String productName;
    private final double unitPrice;
    private final int quantity;

    public OrderItem(int productId, String productName, double unitPrice, int quantity) {

        if (productId <= 0) {
            throw new IllegalArgumentException("Invalid Product ID.");
        }

        if (productName == null) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }

        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be positive.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return unitPrice * quantity;
    }
}

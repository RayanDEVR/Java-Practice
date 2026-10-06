package capstoneApp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final int id;
    private final int customerId;
    private final List<OrderItem> items;

    private final double subtotal;
    private final double discount;
    private final double tax;
    private final double finalTotal;

    private OrderStatus status;
    private PaymentStatus paymentStatus;
    private final PaymentMethod paymentMethod;

    public Order(int id, int customerId, List<OrderItem> items, double subtotal, double discount, double tax,
            double finalTotal, PaymentStatus paymentStatus, PaymentMethod paymentMethod) {
        this.id = id;
        this.customerId = customerId;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.subtotal = subtotal;
        this.discount = discount;
        this.tax = tax;
        this.finalTotal = finalTotal;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;

        if (paymentStatus == PaymentStatus.Success) {
            this.status = OrderStatus.Paid;
        }

        else {
            this.status = OrderStatus.Created;
        }
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void changeStatus(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status cannot be null.");
        }

        boolean allowed = switch (status) {
            case Created -> newStatus == OrderStatus.Paid || newStatus == OrderStatus.Cancelled;
            case Paid -> newStatus == OrderStatus.Processing || newStatus == OrderStatus.Cancelled;
            case Processing -> newStatus == OrderStatus.Shipped;
            case Shipped -> newStatus == OrderStatus.Delivered;
            case Delivered, Cancelled -> false;
        };

        if (!allowed) {
            throw new IllegalArgumentException("Invalid order status transition: " + status + " -> " + newStatus);
        }

        status = newStatus;
    }

    @Override
    public String toString() {
        return "Order #" + id + " | Customer ID: " + customerId + " | Total: " + finalTotal + " | Status: " + status
                + " | Payment: " + paymentStatus;
    }
}

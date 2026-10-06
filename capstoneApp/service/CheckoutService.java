package capstoneApp.service;


import java.util.ArrayList;
import java.util.List;

import capstoneApp.model.*;
import capstoneApp.exception.CartException;
import capstoneApp.exception.OrderException;
import capstoneApp.exception.StockException;

public class CheckoutService {
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    private int nextOrderId = 1;

    private static final double TAX_RATE = 0.05;

    public CheckoutService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public Order checkout(Cart cart, DiscountPolicy discountPolicy, PaymentProcessor paymentProcessor,
            PaymentMethod paymentMethod) {
        if (cart.getItems().isEmpty()) {
            throw new CartException("Cart is empty.");
        }

        for (CartItem item : cart.getItems()) {
            if (item.getQuantity() > item.getProduct().getStock()) {
                throw new StockException("Insufficient stock for " + item.getProduct().getName());
            }
        }

        double subtotal = cart.getSubtotal();
        double discount = discountPolicy.getDiscount(subtotal);
        double taxableAmouunt = subtotal - discount;
        double tax = taxableAmouunt * TAX_RATE;
        double finalTotal = taxableAmouunt + tax;

        boolean paymentSuccess = paymentProcessor.pay(finalTotal);

        if (!paymentSuccess) {
            throw new OrderException("Payment failed. Order cancelled");
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct()
                    .reduceStock(item.getQuantity());
        }

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem: cart.getItems()) {
            Product product = cartItem.getProduct();
            
            orderItems.add(new OrderItem(product.getId(), product.getName(), product.getPrice(), cartItem.getQuantity()));
        }

        Order order = new Order(nextOrderId++, cart.getUserId(), orderItems, subtotal, discount, tax, finalTotal, PaymentStatus.Success, paymentMethod);

        orderRepository.save(order);

        cart.clear();

        notificationService.send("Order #" + order.getId() + " created successfully.");

        return order;
    }
}

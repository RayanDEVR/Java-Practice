package capstoneApp.service;

import capstoneApp.model.*;
import capstoneApp.exception.NotFoundException;
import capstoneApp.exception.OrderException;

public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order getOrder(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found."));
    }

    public void changeStatus(int orderId, OrderStatus newStatus) {
        Order order = getOrder(orderId);
        order.changeStatus(newStatus);
    }

    public void cancelOrder(int orderId, ProductService productService) {
        Order order = getOrder(orderId);

        if (order.getStatus() != OrderStatus.Created && order.getStatus() != OrderStatus.Paid) {
            throw new OrderException("This order cannot be zero.");
        }

        for (OrderItem item : order.getItems()) {
            Product product = productService.getProduct(item.getProductId());

            product.addStock(item.getQuantity());

        }

        order.changeStatus(OrderStatus.Cancelled);
        {

        }
    }
}

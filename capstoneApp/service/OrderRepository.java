package capstoneApp.service;

import capstoneApp.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class OrderRepository {
    private final Map<Integer, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    public Optional<Order> findById(int id) {
        return Optional.ofNullable(orders.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    public List<Order> findByCustomer(int customerId) {
        return orders.values()
                     .stream()
                     .filter(order -> order.getCustomerId() == customerId)
                     .toList();
    }
}

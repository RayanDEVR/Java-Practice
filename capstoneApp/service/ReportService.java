package capstoneApp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import capstoneApp.model.*;

public class ReportService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public ReportService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public double totalRevenue() {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getPaymentStatus() == PaymentStatus.Success)
                .filter(order -> order.getStatus() != OrderStatus.Cancelled)
                .map(Order::getFinalTotal)
                .reduce(0.0, Double::sum);
    }

    public List<Product> lowStockProduct(int maxStock) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getStock() <= maxStock)
                .sorted(Comparator.comparingInt(Product::getStock))
                .toList();
    }

    public Map<OrderStatus, Long> orderByStatus() {
        return orderRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
    }

    public List<Order> toValueOrder(int limit) {
        return orderRepository.findAll()
                .stream()
                .sorted(Comparator.comparingDouble(Order::getFinalTotal).reversed())
                .limit(limit)
                .toList();
    }

    public void printStockReport() {
        System.out.println("\n=== Stock Report ===");

        productRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Product::getStock))
                .forEach(System.out::println);
    }

    public void printRevenueReport() {
        System.out.println("\nTotal Revenue: " + totalRevenue());
    }

    public void printLowStockReport(int maxStock) {
        System.out.println("\n=== Low Stock Report ===");

        lowStockProduct(maxStock).forEach(System.out::println);
    }

    public void printStatusReport() {
        System.out.println("\n=== Order By Status ===");

        orderByStatus().forEach((status, count) -> System.out.println(status + ": " + count));
    }

    public void printTopOrders(int limit) {
        System.out.println("\n=== Top Value Orders ===");
        
        toValueOrder(limit).forEach(System.out::println);
    }
}

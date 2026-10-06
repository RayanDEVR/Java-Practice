/*
Capstone: Online Shopping Backend Simulation   [Capstone Project | Project]
Build a console-driven, entirely in-memory simulation of the business layer of an online shop. Use only concepts 
verified in Videos 1-101.
Required package shape: app, model, service, exception and util (adjust only with a written reason). Suggested 
domain: User/Customer, Product, Cart, CartItem, Order, OrderItem and PaymentMethod; enums for Role, 
OrderStatus and PaymentStatus; interfaces for payment, discount and notification behavior; concrete 
implementations for at least two choices.
Minimum workflows: register user; prevent duplicate username/email according to a documented rule; 
add/update product; stock-in; browse/list/filter/sort products; add/update/remove cart item; calculate 
subtotal/discount/tax/final total; checkout; simulate payment success/failure; create immutable-enough order 
snapshot; change order status only through allowed transitions; cancel an eligible order and restore stock; view 
one order; list a customer’s orders; admin reports for revenue, stock, low-stock products, orders by status and 
top-value orders.

Reliability requirements: private fields; validated constructors/methods; stable identity equality/hashCode; 
custom exceptions; no empty catch; check-before-mutate or rollback-style reasoning; Map lookup, Set 
uniqueness, List histories; Comparator/Comparable where meaningful; forEach and filter/map/reduce/sorted for 
reports; StringBuilder receipts; Scanner/try-with-resources at the outer console boundary. Optional learned
scope extension: synchronize checkout/reservation and demonstrate two threads competing for limited stock.
Delivery milestones: (1) requirements and object diagram, (2) models/enums, (3) repositories as in-memory 
collections, (4) services and exceptions, (5) console menu, (6) reports/streams, (7) concurrency extension, (8) 
refactoring and README. Provide at least 30 manual test cases covering normal, boundary and failure flows.
Done when: A mentor can run the project from one entry point; all minimum workflows pass; no business logic 
is concentrated in main; package dependencies are understandable; a README explains design decisions, test 
evidence and known limitations.
*/

import java.util.Scanner;

import capstoneApp.model.*;
import capstoneApp.service.*;
import capstoneApp.util.*;

public class Ex200CapstoneOnlineShoppingBackendSimulation {
    UserRepository userRepository = new UserRepository();
    ProductRepository productRepository = new ProductRepository();
    OrderRepository orderRepository = new OrderRepository();
    UserService userService = new UserService(userRepository);
    ProductService productService = new ProductService(productRepository);
    CartService cartService = new CartService(productService);
    NotificationService notificationService = new ConsoleService();
    CheckoutService checkoutService = new CheckoutService(orderRepository, notificationService);
    OrderService orderService = new OrderService(orderRepository);
    ReportService reportService = new ReportService(productRepository, orderRepository);

    Cart cart = null;

    public static void main(String[] args) {
        Ex200CapstoneOnlineShoppingBackendSimulation app = new Ex200CapstoneOnlineShoppingBackendSimulation();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("===========================");
                System.out.println("\nONLINE SHOPPING SYSTEM");
                System.out.println("===========================");
                System.out.println("1. Register Customer");
                System.out.println("2. Add Product");
                System.out.println("3. Stock In");
                System.out.println("4. List Products");
                System.out.println("5. Add Product to Cart");
                System.out.println("6. View Cart");
                System.out.println("7. Checkout");
                System.out.println("8. View Order");
                System.out.println("9. Change Order Status");
                System.out.println("10. Cancel Order");
                System.out.println("11. Customer Orders");
                System.out.println("12. Admin Reports");
                System.out.println("0. Exit");

                System.out.println("Choose: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                try {
                    switch (choice) {
                        case 1 -> {
                            System.out.println("Username: ");
                            String username = scanner.nextLine();

                            System.out.println("Email: ");
                            String email = scanner.nextLine();

                            System.out.println("Password: ");
                            String password = scanner.nextLine();

                            User user = app.userService.register(username, email, password, Role.Customer);
                            app.cart = new Cart(user.getId());

                            System.out.println("Registered: " + user);
                        }

                        case 2 -> {
                            System.out.println("Product ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Name: ");
                            String name = scanner.nextLine();

                            System.out.println("Price: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.println("Stock: ");
                            int stock = scanner.nextInt();
                            scanner.nextLine();

                            app.productService.addProduct(new Product(id, name, price, stock));

                            System.out.println("Product added.");
                        }

                        case 3 -> {
                            System.out.println("Product ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Quantity: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();

                            app.productService.stockIn(id, quantity);

                            System.out.println("Stock updated");
                        }

                        case 4 -> {
                            System.out.println("\n=== Products ===");
                            app.productService.sortByName().forEach(System.out::println);
                        }

                        case 5 -> {
                            if (app.cart == null) {
                                System.out.println("Register first.");
                                break;
                            }

                            System.out.println("Product Id: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Quantity: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();

                            app.cartService.addItem(app.cart, id, quantity);

                            System.out.println("Added to cart.");
                        }

                        case 6 -> {
                            if (app.cart == null) {
                                System.out.println("Register first.");
                                break;
                            }

                            System.out.println("\n=== Cart ===");
                            app.cart.getItems().forEach(item -> System.out.println(item.getProduct().getName() + " x "
                                    + item.getQuantity() + " = " + item.getTotal()));
                            System.out.println("Subtotal: " + app.cart.getSubtotal());
                        }

                        case 7 -> {
                            if (app.cart == null) {
                                System.out.println("Register first.");
                                break;
                            }

                            PaymentProcessor payment = new CardPayment(true);
                            DiscountPolicy discount = new PercentageDiscount(10);
                            Order order = app.checkoutService.checkout(app.cart, discount, payment, PaymentMethod.Card);
                            System.out.println(ReceiptUtil.createReceipt(order));
                        }

                        case 8 -> {
                            System.out.println("Order ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println(app.orderService.getOrder(id));
                        }

                        case 9 -> {
                            System.out.println("Order id: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("1. Processing");
                            System.out.println("2. Shipped");
                            System.out.println("3. Delivered");

                            int option = scanner.nextInt();
                            scanner.nextLine();

                            OrderStatus status = null;
                            switch (option) {
                                case 1 -> status = OrderStatus.Processing;
                                case 2 -> status = OrderStatus.Shipped;
                                case 3 -> status = OrderStatus.Delivered;
                                default -> System.out.println("Invalid status option.");
                            }

                            if (status != null) {
                                app.orderService.changeStatus(id, status);
                                System.out.println("Status updated.");
                            }
                        }

                        case 10 -> {
                            System.out.println("Order ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();

                            app.orderService.cancelOrder(id, app.productService);
                            System.out.println("Order cancelled and stock restored.");
                        }

                        case 11 -> {
                            if (app.cart == null) {
                                System.out.println("Register first.");
                                break;
                            }

                            System.out.println("\n=== CUSTOMER ORDERS ===");
                            app.orderRepository.findByCustomer(app.cart.getUserId()).forEach(System.out::println);
                        }

                        case 12 -> {
                            app.reportService.printRevenueReport();
                            app.reportService.printStockReport();
                            app.reportService.printLowStockReport(5);
                            app.reportService.printStatusReport();
                            app.reportService.printTopOrders(3);
                        }

                        case 0 -> {
                            running = false;
                            System.out.println("Goodbye!");
                        }

                        default -> System.out.println("Invalid choice.");
                    }
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
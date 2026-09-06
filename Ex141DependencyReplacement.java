/*
Dependency Replacement   [Refactoring | Advanced]
OrderService directly creates EmailSender. Refactor it to accept a NotificationSender interface through its 
constructor so a ConsoleSender can be used in tests/demo.
Done when: OrderService no longer depends on a concrete notification implementation.
*/

interface NotificationSender {
    void send(String massage);
}

class EmailSender implements NotificationSender {
    @Override 
    public void send(String massage) {
        System.out.println("Email: " + massage);
    }
}

class ConsoleSender implements NotificationSender {
    @Override
    public void send(String massage) {
        System.out.println("Console: " + massage);
    }
}

class OrderService {
    private NotificationSender sender;

    OrderService(NotificationSender sender) {
        this.sender = sender;
    }

    public void placeOrder(String item) {
        System.out.println("Order placed: " + item);
        sender.send("Your order for " + item + " is confirmed.");
    }
}

public class Ex141DependencyReplacement {
    public static void main(String[] args) {
        OrderService prodService = new OrderService(new EmailSender());
        OrderService testService = new OrderService(new ConsoleSender());

        prodService.placeOrder("Pen");
        testService.placeOrder("Notebook");
    }
}

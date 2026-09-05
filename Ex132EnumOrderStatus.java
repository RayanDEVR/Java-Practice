/*
Enum Order Status   [Build from Scratch | Advanced]
Create OrderStatus with CREATED, PAID, PACKED, SHIPPED, DELIVERED and CANCELLED. Use switch to print 
allowed next actions.
Done when: Unknown free-form strings are eliminated and every enum constant has defined behavior.
*/

enum OrderStatus {
    CREATED, PAID, PACKED, SHIPPED, DELIVERED, CANCELLED;
}


public class Ex132EnumOrderStatus {
    static void printNextAction(OrderStatus status) {
        switch (status) {
            case CREATED -> System.out.println("next: Make payment or cancel.");
            case PAID -> System.out.println("next: Pack the order.");
            case PACKED -> System.out.println("next: Ship the order.");
            case SHIPPED -> System.out.println("next: Await delivery.");
            case DELIVERED -> System.out.println("Order complete, no futher action.");
            case CANCELLED -> System.out.println("Order cancelled, no further action.");

        }
    }
    
    public static void main(String[] args) {
        printNextAction(OrderStatus.CREATED);
        printNextAction(OrderStatus.PAID);
        printNextAction(OrderStatus.PACKED);
        printNextAction(OrderStatus.SHIPPED);
        printNextAction(OrderStatus.DELIVERED);
        printNextAction(OrderStatus.CANCELLED);
    }
}

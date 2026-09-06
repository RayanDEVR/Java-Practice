/*
Enum State Transition Guard   [Scenario-Based | Advanced]
Implement canMoveTo(nextStatus) behavior for an order status. Prevent shipping before payment and prevent 
changes after delivered/cancelled.
Done when: A transition table and tests cover valid and invalid moves.
*/

enum OrderStatus {
    CREATED, PAID, SHIPPED, DELIVERED, CANCELLED;

    boolean canMoveTo(OrderStatus next) {
        return switch (this) {
            case CREATED -> next == PAID || next == CANCELLED;
            case PAID -> next == SHIPPED || next == CANCELLED;
            case SHIPPED -> next == DELIVERED;
            case DELIVERED, CANCELLED -> false;
        };
    }

    static void tryTransition(OrderStatus from, OrderStatus to) {
        System.out.println(from + " -> " + to + " allowed? " + from.canMoveTo(to));
    }
}

public class Ex134EnumStateTransitionGuard {
    
    public static void main(String[] args) {
        OrderStatus.tryTransition(OrderStatus.CREATED, OrderStatus.PAID);
        OrderStatus.tryTransition(OrderStatus.CREATED, OrderStatus.SHIPPED);
        OrderStatus.tryTransition(OrderStatus.PAID, OrderStatus.SHIPPED);
        OrderStatus.tryTransition(OrderStatus.DELIVERED, OrderStatus.CREATED);
        OrderStatus.tryTransition(OrderStatus.CANCELLED, OrderStatus.PAID);
       
    }
}

/*
Catch, Translate and Preserve Meaning   [Refactoring | Advanced]
A service catches a generic exception and prints “error.” Replace it with specific handling or translation to a 
domain exception while keeping the original reason in the message/cause concept as far as taught.
Done when: Callers receive a meaningful business-level failure and no empty catch remains.
*/


class OrderProcessingException extends Exception {
    public OrderProcessingException(String massage) {
        super(massage);
    }
}

class OrderService {
    void processOrder(int quantity, int stock) throws OrderProcessingException {
        if (quantity > stock)
            // throw new OrderProcessingException("Stock issue");       //before
            throw new OrderProcessingException("Cannot process order: requested " + quantity + ", available: " + stock); 

        System.out.println("Order processed successfully");
    }
}

public class Ex153CatchTranslateAndPreserveMeaning {
    public static void main(String[] args) {
        OrderService order = new OrderService();
        try{
        order.processOrder(2, 10);
        }
        catch (OrderProcessingException e) {
            // System.out.println("error");         before
            System.out.println("Order failed; " + e.getMessage());
        }
    }
}

/*
Custom InvalidOrderException   [Scenario-Based | Advanced]
Create an exception for checkout with an empty cart, non-positive quantity or insufficient stock. Decide whether 
one exception with meaningful messages is enough at this scope.
Done when: Every invalid condition is identifiable and order/inventory state remains unchanged.
*/

class InvalidOrderException extends Exception {
    public InvalidOrderException(String massage) {
        super(massage);
    }
}

class CheckoutValidator {
    void checkout(int cartSize, int quantity, int availableStock) throws InvalidOrderException{
        if (cartSize == 0)
            throw new InvalidOrderException("Cart is empty");
        if (quantity <= 0)
            throw new InvalidOrderException("Quantity must be positive, got " + quantity);
        if (quantity > availableStock)
            throw new InvalidOrderException
            ("Insufficient stock: Requested " + quantity + ", available " + availableStock);

        System.out.println("Checkout succeeded for quantity " + quantity);
    }
}

public class Ex151CustomInvalidOrderException {
    public static void main(String[] args) {
        CheckoutValidator cases = new CheckoutValidator();
        try {
            cases.checkout(0, 10, 100);
        }
        catch (InvalidOrderException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }

        try {
            cases.checkout(10, 100, 90);
        }
        catch (InvalidOrderException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }

        try {
            cases.checkout(10, -10, 100);
        }
        catch (InvalidOrderException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }

        try {
            cases.checkout(10, 10, 100);
        }
        catch (InvalidOrderException e) {
            System.out.println("Order rejected: " + e.getMessage());
        }
    }
}

/*
Refactor a God Method   [Refactoring | Intermediate]
A checkout method validates stock, computes totals, applies discount, prints a receipt and updates inventory. 
Break it into cohesive methods without creating unnecessary one-line wrappers.
Done when: Each method has a clear name/contract and state changes happen only after validation.
 */

class checkoutService {
    public void checkout(int stockValidate, int quantity, double total, double discount) {
        if (stockValidate >= 10) {
            return;
        }
    }
}

public class Ex059RefactorAGodMethod {
    public static void main(String[] args) {
        checkoutService a = new checkoutService();
        a.checkout(22, 0, 0, 0);
    }
}

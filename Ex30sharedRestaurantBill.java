/*
Shared Restaurant Bill   [Scenario-Based | Beginner]
Calculate subtotal, service charge, tax and equal per-person share. Rejecting invalid guest counts belongs to the 
next level; here focus on correct types and formulas.
Done when: The per-person result remains fractional and all intermediate values are visible.
 */

public class Ex30sharedRestaurantBill {
    public static void main(String[] args) {
        int guests = 5;
        double subtotal = 2000;
        double serviceCharge = 500;
        double tax = (double) 10/100;
        
        double preTaxBill = subtotal + serviceCharge;
        double afterTaxBill = preTaxBill + (preTaxBill * tax);
        double total = afterTaxBill;
        
        double perPersonBill = total / guests;

        System.out.println("Per Guest's Bill: " + perPersonBill);
    }
}

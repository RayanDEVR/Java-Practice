/*
Tiered Discount Engine   [Scenario-Based | Beginner]
Apply discount tiers based on subtotal and membership: no discount, standard, bulk, and premium-member 
bonus. Define precedence so only the intended combination applies.
Done when: A decision table and tests prove there is no accidental double discount.
 */

public class Ex047TieredDiscountEngine {
    public static void main(String[] args) {
        double subtotal = 1200;
        String membership = "monthly";

        if(subtotal <= 500)
            System.out.println("Discount Tier: No Discount");

        else if((subtotal > 500 && subtotal <=1000) || membership == "weekly")
            System.out.println("Discount Tier: Standard - 5%");

        else if((subtotal > 1000 && subtotal <=1500) || membership == "monthly")
            System.out.println("Discount Tier: Bulk - 10%");

        else if(subtotal > 1500 || membership == "yearly")
            System.out.println("Discount Tier: Premium Membership Bonus - 15%");

    }
}

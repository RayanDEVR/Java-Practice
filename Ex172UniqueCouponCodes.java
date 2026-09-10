/*
Unique Coupon Codes   [Scenario-Based | Advanced]
Use Set/HashSet to store redeemed coupon codes and reject duplicates. Compare output order with insertion 
order and avoid relying on it.
Done when: A duplicate redemption is detected and the business rule is tied to Set uniqueness.
*/

import java.util.HashSet;
import java.util.Set;

public class Ex172UniqueCouponCodes {
    public static void main(String[] args) {
        Set<String> redeemedCoupon = new HashSet<>();

        String[] attempts = { "SAVE10", "WELCOME", "RUN12T6", "SAVE10", "PHUTO3N2" };

        for (String coupon : attempts) {
            boolean added = redeemedCoupon.add(coupon);
            if (added) {
                System.out.println(coupon + " redeemed successfully.");
            }
            else {
                System.out.println(coupon + " Rejected: Alrady redeemed(dublicate).");
            }
        }
    }
}

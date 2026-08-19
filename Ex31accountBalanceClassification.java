/*
 Account Balance Classification   [Basic Coding | Beginner]
Using if/else-if/else, classify a balance as overdrawn, zero, low, healthy or premium according to supplied 
thresholds.
Done when: Every interval is non-overlapping and boundary tests are documented.
 */

public class Ex31accountBalanceClassification {
    public static void main(String[] args) {
        int bankBalance = 1500;
        String type;

        if(bankBalance < 0)
            type = "Overdrawn";
        else if (bankBalance == 0)
            type = "Zero";
        else if (bankBalance > 0 && bankBalance < 500)
            type = "Low";
        else if (bankBalance >= 500 && bankBalance < 1000)
            type = "Healthy";
        else
            type = "Premium";

        System.out.println("Account Status: " + type);
    }
}

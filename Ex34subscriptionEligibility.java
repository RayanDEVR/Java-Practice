/*
Subscription Eligibility   [Scenario-Based | Beginner]
A user may subscribe when age is at least 18, account is active, email is verified and countrySupported is true. 
Premium requires an additional income rule. Encode and explain the logic.
Done when: The program prints the exact failed requirements instead of only true/false.
 */

public class Ex34subscriptionEligibility {
    public static void main(String[] args) {
        int age = 22;
        boolean accountActive = true;
        boolean emailVerified = true;
        boolean countrySupported = true;
        double income = 60000;

        boolean canSubscribe = age >= 18 && accountActive && emailVerified && countrySupported;
        
        if (canSubscribe) {
            System.out.println("Subscription Allowed");

            if (income >= 50000) 
                System.out.println("Premium Subscribtion Eligible");

             else 
                 System.out.println("Standard Subscription");
        }
        else 
        {
            if(age < 18)
                System.out.println("Failed: Age must be at least 18");

            else if(!accountActive)
                System.out.println("Failed: Account must be activated");

            else if(!emailVerified)
                System.out.println("Failed: E-mail is not varified");

            else if(!countrySupported)
                System.out.println("Failed: Country is not supported");
        }
    }
}

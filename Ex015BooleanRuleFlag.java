/*
Boolean Rule Flags   [Basic Coding | Beginner]
Create boolean variables for emailVerified, accountActive and paymentComplete. Produce a final canPlaceOrder 
condition using logical operators.
Done when: At least six truth combinations are tested and the final condition matches the written business rule.
 */


public class Ex015BooleanRuleFlag {
    public static void main(String[] args) {
        boolean emailVerified = true;
        boolean accountActive = false;
        boolean paymentComplete = true;
        
        boolean canPlaceOrder = emailVerified && accountActive && paymentComplete;
        
        if (canPlaceOrder == true)
          System.out.println("Status: Done");
        
        else
          System.out.println("Status: Complete all the stages first");
    }
}

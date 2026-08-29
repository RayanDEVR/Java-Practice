/*
Mutable Text Bug Hunt   [Bug Fixing | Intermediate]
Given a StringBuilder shared through two references, predict how append through one reference affects the 
other. Repair code that accidentally reuses the same builder for two receipts.
Done when: Each receipt gets independent mutable state and the aliasing cause is explained.
*/

public class Ex99MutableTextBugHunt {
    public static void main(String[] args) {
        System.out.println("===BUGGY VERSION===");
        StringBuilder shared = new StringBuilder();
        StringBuilder receipt1 = shared;
        StringBuilder receipt2 = shared; //both point to the same object
        
        receipt1.append("Item-1 ");
        receipt2.append("Item-2 ");

        System.out.println("Receipt 1: " + receipt1);
        System.out.println("Receipt 2: " + receipt2);


        System.out.println();
        System.out.println("===FIXED VERSION===");
        StringBuilder fixedReceipt1 = new StringBuilder();
        StringBuilder fixedReceipt2 = new StringBuilder();

        fixedReceipt1.append("Item-1 ");
        fixedReceipt2.append("Item-2 ");

        System.out.println("Receipt 1: " + fixedReceipt1);
        System.out.println("Receipt 2: " + fixedReceipt2);
    }
}

/*
Insert and Delete a Receipt Marker   [Code Completion | Intermediate]
Complete StringBuilder code that inserts an "URGENT" marker near the beginning and removes an accidental 
character with deleteCharAt.
Done when: Indexes are validated against the current sequence and final text is correct.
*/

public class Ex93InsertAndDeleteAReceiptMarker {
    public static void main(String[] args) {
        StringBuilder receipt = new StringBuilder("Order #1034  Confirmed");
        System.out.println("Before delete: " + receipt);        //Order #1034X Confirmed

        receipt.deleteCharAt(11);
        System.out.println("After delete: " + receipt);         //Order #1034 Confirmed

        receipt.insert(0, "URGENT ");
        System.out.println("After insert: " + receipt);         //ARGENT Order #1034 Confirmed
    }
}

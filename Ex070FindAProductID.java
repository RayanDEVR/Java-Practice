/*
Find a Product ID   [Scenario-Based | Intermediate]
Search an array of product IDs for a requested ID and report its index or not found. Explain why this is 
acceptable practice here but not the main focus of the workbook.
Done when: First, middle, last and absent IDs are tested. 
*/

public class Ex070FindAProductID {
    public static void main(String[] args) {
        int[] productIDs = { 1001, 1002, 1003, 1004, 1005 };
        int productID = 1003;

        for (int i = 0; i < productIDs.length; i++) {
            if (productIDs[i] == productID) {
                System.out.println("Found the ID at index " + i);
                return;
            }
        }

        System.out.println( "Not Found");
    }
}

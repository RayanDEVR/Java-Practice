/*
Exception Anti-Pattern Review   [Code Reading | Advanced]
Review five snippets: empty catch, catch Exception, exception for normal boolean choice, printStackTrace-only 
handling and state mutation before validation. Explain and repair each.
Done when: Each repair preserves useful failure information and normal business logic remains readable.
*/

public class Ex159ExceptionAntiPatternReview {
    public static void main(String[] args) {
        System.out.println("--- Anti-pattern 1: empty catch ---");
        try {
            Integer.parseInt("bad");
        } 
        catch (NumberFormatException e) {
            //	FIX: at minimum, log or report something meaningful instead	of silence
            System.out.println("Fixed: could not parse number -> " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Anti-pattern 2: catching generic Exception ---");
        try {
            Object[] arr = new String[3];
            arr[0] = 10; //	ArrayStoreException in real Java, caught broadly below (illustrative)
        } catch (Exception e) {
            //	FIX: catch the SPECIFIC exception type where possible
            System.out.println("Fixed (should be specific): caught " + e.getClass().getSimpleName());
        }

        System.out.println();
        System.out.println("--- Anti-pattern 3: exception for normal boolean choice ---");
        System.out.println("(bad): using try/catch just to check if a String is numeric.");
        System.out.println("FIX: use a plain boolean check instead:");
        
        String text = "123a";
        boolean isNumeric = text.chars().allMatch(Character::isDigit);
        System.out.println("isNumeric(\"" + text + "\") = " + isNumeric);
        System.out.println();
        System.out.println("--- Anti-pattern 4: printStackTrace-only handling ---");
        try {
            throw new RuntimeException("Simulated failure");
        } catch (RuntimeException e) {
            // FIX: give the caller/user a real signal, not just a trace dump
            System.out.println(
                    "Fixed: operation failed (" + e.getMessage() + "), showing user a retry option.");
        }
        System.out.println();
        System.out.println("--- Anti-pattern 5: mutating state before validation ---");

        int[] stock = { 5 };
        int requested = 10;
        System.out.println("BEFORE (bad): stock[0] -= requested; THEN checking if it went negative.");
        System.out.println("FIX: validate first, mutate only if valid:");
    
        if (requested <= stock[0]) {
            stock[0] -= requested;
            System.out.println("Stock reduced to " + stock[0]);
        } 
        else {
            System.out.println("Rejected: requested " + requested + " exceeds stock " + stock[0]
                    + "; stock unchanged.");
        }
    }

}


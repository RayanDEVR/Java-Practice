/*
Batch Invoice Numbers   [Basic Coding | Beginner]
Use a for loop to print invoice numbers INV-1001 through INV-1020 and mark every fifth invoice for audit.
Done when: The first/last values and audit frequency are correct.
 */

public class Ex041BatchInvoiceNumbers {
    public static void main(String[] args) {

        for (int i = 1001; i<=1020; i++)
        {
            System.out.print("INV-" + i);

            if (i % 5 == 0)
                System.out.print("--> Adult");

          System.out.println();
        }
        
        
    }
}

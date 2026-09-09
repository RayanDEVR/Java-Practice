/*
Try-with-Resources Conversion   [Refactoring | Advanced]
Refactor manually opened console-reader code into try-with-resources. Explain when the resource is closed, 
including when an exception occurs.
Done when: No explicit close is required in normal control flow and the scope is clear.
*/

import java.util.Scanner;

public class Ex157TryWithResourcesConversion {
    public static void main(String[] args) {
        String line1;
        System.out.println("--- Before: manual close ---");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter your line: ");
            line1 = scanner.nextLine();
            System.out.println(line1);
        }
        finally {
            scanner.close();
        }


        System.out.println("--- After: try-with-resources ---");
        String line2;
        try (Scanner scanner2 = new Scanner(System.in)) {
            System.out.println("Enter your line: ");
            line2 = scanner2.nextLine();
            System.out.println(line2);
        }
    }
}

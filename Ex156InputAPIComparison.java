/*
Input API Comparison   [Code Reading | Advanced]
Implement the same two-value input with Scanner and BufferedReader. Compare convenience, conversion 
responsibility and checked-exception/resource considerations based on the lessons.
Done when: The comparison is evidence-based and both versions work.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex156InputAPIComparison {
    public static void main(String[] args) throws IOException {
        System.out.println("--- Using Scanner ---");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String nameA = scanner.next();
        System.out.println("Enter quantity: ");
        int quantityA = scanner.nextInt();
        System.out.println("Name: " + nameA + ", Quantity: " + quantityA);
        scanner.close();

        System.out.println("--- Using BufferReader ---");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        String nameB = bf.readLine();
        System.out.println("Enter quantity: ");
        int quantityB = Integer.parseInt(bf.readLine());
        System.out.println("Name: " + nameB + ", Quantity: " + quantityB);
        bf.close();
    }

    
}

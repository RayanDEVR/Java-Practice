/*
Scanner Input Validation Loop   [Build from Scratch | Advanced]
Read age and plan option with Scanner. Keep asking until each is in range, catching invalid numeric input if 
demonstrated through Scanner behavior.
Done when: The program survives non-numeric and out-of-range attempts and finally records valid values.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex154ScannerInputValidationLoop {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int age = 0;

            while (true) {
                try {
                    System.out.println("Enter your age: ");
                    age = scanner.nextInt();

                    if (age >= 18 && age <= 100)
                        break;

                    System.out.println("Age must be between 18 and 100.");
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
            }

            System.out.println("Accepted Age: " + age);
        }
    }
}

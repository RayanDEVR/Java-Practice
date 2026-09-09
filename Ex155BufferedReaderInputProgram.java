/*
BufferedReader Input Program   [Build from Scratch | Advanced]
Read a customer name and numeric quantity using BufferedReader/InputStreamReader. Convert the numeric 
text using the wrapper conversion encountered earlier and handle invalid input.
Done when: Valid input creates an order summary and invalid quantity produces a controlled message.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex155BufferedReaderInputProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name = null;
            int quantity = 0;

            System.out.println("Enter your name: ");
            try {
                name = scanner.nextLine();

                if (name.matches("-?\\d+")) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter valid name.");
            }

            System.out.println("Enter quantity: ");
            try {
                quantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter valid number.");
            }

            System.out.println("Order summary: " + name + " ordered " + quantity + " items.");
        }
    }
}

/*
Robust Console Registration   [Build from Scratch | Advanced]
Build a registration flow reading id, name, age and plan. Validate fields, represent plan with enum, throw a 
custom exception for invalid domain data and use try-with-resources.
Done when: The flow can recover from bad input, never constructs an invalid registration and prints a final 
summary.
*/

import java.util.Scanner;

enum Plan {
    BASIC, STANDARD, PREMIUM
}

class InvalidRagistrationException extends Exception {
    public InvalidRagistrationException(String message) {
        super(message);
    }
}

public class Ex160RobustConsoleRegistration {
    static  void register(int id, String name, int age, String planText) throws InvalidRagistrationException {
        if (name == null || name.isEmpty())
            throw new InvalidRagistrationException("Name is required.");
        if (age < 18 || age > 100)
            throw new InvalidRagistrationException("Age must be between 18 and 100.");
        
        Plan plan;
        try {
            plan = Plan.valueOf(planText.toUpperCase());
            System.out.println("Registered: ID - " + id + ", Name: " + name + ", Age: " + age + ", Plan: " + planText.toUpperCase());

        }
        catch (IllegalArgumentException e) {
            System.out.println("Unknown plan: " + planText);
        }

        
    }

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter ID: ");
            int id = scanner.nextInt();

            System.out.println("Enter your name: ");
            String name = scanner.next();

            System.out.println("Enter your age: ");
            int age = scanner.nextInt();

            System.out.println("Enter your plan(BASIC/STANDARD/PREMIUM): ");
            String plan = scanner.next();
            
            try{
                register(id, name, age, plan);
            }
            catch (InvalidRagistrationException e) {
                System.out.println("Resigtrationn failed: " + e.getMessage());
            }
        }
    }
}

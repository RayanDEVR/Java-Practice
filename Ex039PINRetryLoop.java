/*
PIN Retry Loop   [Scenario-Based | Beginner]
Using a while loop and pre-supplied attempts, simulate at most three PIN attempts. Stop conceptually when 
correct by controlling the loop condition rather than introducing untaught flow tricks.
Done when: The program handles success on attempt 1, 2 or 3 and lockout after three failures.
 */

public class Ex39PINRetryLoop {
    public static void main(String[] args) {
        int correctPIN = 1234;

        int[] attempts = {1111, 2222, 1234};
        
        int i = 0;

        while (i < attempts.length && i < 3 && attempts[i] != correctPIN) {
            System.out.println("Wrong PIN");

            i++;
        }

        if(i < attempts.length  && attempts[i] == correctPIN)
            System.out.println("Login successful");

        else
            System.out.println("Account locked");
    }
}

/* 
Fix Login String Comparison   [Bug Fixing | Intermediate]
A login check uses username == "admin" and fails for a separately constructed equal String. Repair it and explain 
why the original can appear to work in some cases.
Done when: Content comparison works for literal and newly constructed input values.
*/

import java.util.Scanner;

class Username {
    public boolean isAdmin(String username) {
        return "admin".equals(username);
    }
}

public class Ex087FixLoginStringComparison {
    public static void main(String[] args) {
        System.out.println("Enter your Username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.next();

        Username u = new Username();
        if (u.isAdmin(username)) {
            System.out.println("Correct username.");
        }
        else
            System.out.println("Wrong username.");

        
        sc.close();
    }
}

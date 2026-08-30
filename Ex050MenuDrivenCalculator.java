/*
Menu-Driven Calculator   [Build from Scratch | Beginner]
Create a repeated calculator menu for add, subtract, multiply, divide and exit. Handle division by zero with a 
normal condition; formal exceptions come later.
Done when: All operations work, invalid options are reported and the loop exits cleanly.
 */

public class Ex050MenuDrivenCalculator {
    public static void main(String[] args) {
        double a = 2;
        double b = 0;
        double result = a/b;

        if (result == a+b)
            result = a + b;

        else if (result == a-b)
            result = a - b;
        
        else if (result == a*b)
            result = a * b;
        
        else if (result == a/b)
            result = a / b;
        
        if (b == 0)
            System.out.println("Can not divided by Zero");

        System.out.println(result);
    }
}

/*
Short-Circuit Safety   [Output Prediction | Beginner]
Predict whether a dangerous division or method call is evaluated in conditions using && and ||. Construct a safe 
condition that checks a denominator before division.
Done when: No division-by-zero occurs and the explanation identifies the short-circuit point.
 */

public class Ex025shortCircuitSafety {
    public static void main(String[] args) {
        double number = 4;
        double divisor = 0;
        double result = number / divisor;

        if(divisor != 0 && divisor > 0)
            System.out.println(result);
        else
            System.err.println("Divisor can't be Zero");

    }
}

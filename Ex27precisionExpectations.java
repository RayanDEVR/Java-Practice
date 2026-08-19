/*
 Precision Expectations   [Code Reading | Beginner]
Run a small double calculation such as 0.1 + 0.2 and compare it with 0.3. Explain the observation without 
introducing libraries outside the playlist. State a practical testing caution.
Done when: The student does not claim all decimal fractions are represented exactly and avoids direct equality 
as a universal money rule.
 */

public class Ex27precisionExpectations {
    public static void main(String[] args) {
        double a = 0.1 + 0.2;
        double b = 0.3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a==b ? true : false);
    }
}

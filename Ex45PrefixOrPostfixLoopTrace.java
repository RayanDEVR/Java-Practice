/*
Prefix/Postfix Loop Trace   [Output Prediction | Beginner]
Trace code that prints i++, ++i and i inside a loop. Rewrite it into a clearer version that avoids clever increments 
in output expressions.
Done when: Prediction is accurate and refactored output is identical.
 */

public class Ex45PrefixOrPostfixLoopTrace {
    public static void main(String[] args) {
        for (int i = 1; i <= 5;)
        {
            System.out.println( "i++ = " + i++ + ", i = " + i );
            System.out.println();
            // System.out.println("++i = " + ++i);
        }
    }
}

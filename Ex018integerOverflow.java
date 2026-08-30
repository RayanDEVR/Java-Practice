/*
Integer Overflow in a Sales Total   [Bug Fixing | Beginner]
A program multiplies two large int values for priceInCents and quantity and produces a wrong total. Diagnose 
the problem and fix it by choosing appropriate types and operand placement.
Done when: The corrected total is exact, and the explanation identifies when overflow occurs in the expression.
 */

public class Ex018integerOverflow {
    public static void main(String[] args) {
        int priceInCents = 20000;
        int quantity = 300000;

        long total = (long) priceInCents * quantity;

        System.out.println(total);
    }
}


//the value of total is out the range of int(-2^31 - (2^31 - 1) = -2,147,483,648 - 2,147,483,647). That's why overflow occured.
//the range of long(-9,223,372,036,854,775,808 - 9,223,372,036,854,775,807) is enough able to carry the result

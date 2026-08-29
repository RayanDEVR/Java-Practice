/*
Readable Literals   [Refactoring | Beginner]
Refactor hard-to-read literals into binary, hexadecimal or underscore-separated forms where appropriate—for 
example permissions, color-like values and a large account limit. Confirm the decimal values remain equal.
Done when: The refactored code prints the same values and the notation choice is explained.
 */

public class Ex13ReadableLiterals {
    public static void main(String[] args) {
        int num1 = 10_000_000;
        int num2 = 0b101101;
        boolean b = num2 == 45;

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(b);

    }
}

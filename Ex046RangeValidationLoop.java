/*
Range Validation Loop   [Build from Scratch | Beginner]
Given a sequence of attempted ages, keep checking until a value from 18 to 120 appears. Count invalid 
attempts.
Done when: The valid value and invalid-attempt count are correct for multiple sequences.
 */

public class Ex046RangeValidationLoop {
    public static void main(String[] args) {
        int[] ages = { 12, 11, 26, 9, 13, 16, 20 };
        int invalid = 1;

        for (int age : ages) {
            if (age >= 18 && age <= 120) {
                System.out.println("Valid Age: " + age);
                break;
            } else {
                invalid++;
            }
        }
        
        System.out.println("Invalid attempts: " + invalid);
    }
}

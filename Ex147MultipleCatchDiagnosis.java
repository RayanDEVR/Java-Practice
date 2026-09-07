/*
Multiple Catch Diagnosis   [Code Reading | Advanced]
Create one block that can fail from invalid array index and arithmetic division. Catch specific exceptions in a valid 
order and print distinct explanations.
Done when: Specific catches appear before broader ones and both failures are demonstrated independently.
*/

public class Ex147MultipleCatchDiagnosis {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int num[] = { 1, 3, 5, 3 };

        try{
            b = 21/a;
            System.out.println(num[4]);
        }

        catch (ArithmeticException e) {
            System.out.println("Can't divided by ZERO");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Select a number 0-3");
        }

        catch (Exception e) {
            System.out.println("Something is wrong.");
        }

        System.out.println(b);
    }
}

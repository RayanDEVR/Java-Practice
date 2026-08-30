/*
Boundary Failure Investigation   [Output Prediction | Intermediate]
Predict exactly which iteration fails in loops using i <= values.length and i < values.length - 1. Correct both based 
on the intended traversal.
Done when: The explanation identifies the last valid index and what each original loop skipped or exceeded. 
*/

public class Ex072BoundaryFailureInvestigation {
    public static void main(String[] args) {
        int[] values = { 10, 20, 30, 40, 50 };

        for (int i = 0; i <= values.length; i++) {          //gives an error: ArrayIndexOutOfBoundsException
            System.out.println(values[i]);
        }
        System.out.println();

        for (int i = 0; i < values.length - 1; i++) {       //skips last element of the array
            System.out.println(values[i]);
        }
        System.out.println();

        for (int i = 0; i < values.length; i++) {           //correct code
            System.out.println(values[i]);
        }
        System.out.println();
        
    }
}

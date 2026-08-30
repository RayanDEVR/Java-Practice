/*
Compound Assignment and Increment   [Output Prediction | Beginner]
Trace inventory through stock += received, stock -= sold, stock++, ++stock and stock *= packSize. Predict each 
printed value before execution.
Done when: The trace explains prefix versus postfix when used inside larger expressions and recommends the 
clearer business form.
 */


public class Ex021compoundAssignmentAndIncrement {
    public static void main(String[] args) {
        
        int stock = 100;
        int received = 20;
        int sold = 15;
        int packSize = 5;
        
        stock += received;
        System.out.println("After receiving: " +stock);         // 120

        stock -= sold;
        System.out.println("After selling: " + stock);          //105

        stock++;
        System.out.println("After stock++: " + stock);          //105

        ++stock;
        System.out.println("After ++stock: " + stock);          //107

        stock *= packSize;
        System.out.println("After packing: " + stock);      //535
    }
}

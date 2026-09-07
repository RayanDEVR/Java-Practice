/*
Try/Catch Division Repair   [Bug Fixing | Advanced]
A report program divides total by participantCount and crashes at zero. Add focused exception handling and a 
meaningful fallback message, then discuss whether pre-validation is clearer.
Done when: Normal cases remain unchanged and zero does not terminate the program unexpectedly.
*/

class DivisionRepair {
    double total;
    int participantCount;

    void calculateAverage(double total, int participantCount){
        try {
            if (participantCount == 0) {
                throw new ArithmeticException();
            }
            System.out.println("Average: " + total / participantCount);
        }
    
        catch (ArithmeticException e) {
            System.out.println("Cannot calculate average: no participants");
        }
    };
}

public class Ex146TryCatchDivisionRepair {
    public static void main(String[] args) {
        DivisionRepair d = new DivisionRepair();
        
        d.calculateAverage(1500, 10);
        d.calculateAverage(1500, 0);
    }
}
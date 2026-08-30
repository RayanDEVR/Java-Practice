/*
Operator Precedence Audit   [Bug Fixing | Beginner]
A commission formula mixes addition, multiplication and division without parentheses. State the existing 
evaluation order, then add parentheses so the code visibly matches the business formula.
Done when: The original and corrected results are shown with a justification for the intended one.
 */

public class Ex022operatorPrecedenceAudit {
    public static void main(String[] args) {
        double sales = 10000;
        double bonus = 500;
        double commissionRate = 10;

        double commission = sales + bonus * commissionRate / 100;

        System.out.println(commission);             //wrong formula
    
    
    
        double sales1 = 10000;
        double bonus1 = 500;
        double commissionRate1 = 10;

        double commission1 = (sales1 + bonus1) * commissionRate1 / 100;

        System.out.println(commission1);            //correct formula
    
    }
}

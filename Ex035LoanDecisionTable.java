/*
Loan Decision Table   [Scenario-Based | Beginner]
Translate a small decision table using income, existingDebt, creditScore and employed status into Approved, 
Manual Review or Rejected.
Done when: The implementation matches at least eight table rows, including borderline cases.
 */

public class Ex035LoanDecisionTable {
    public static void main(String[] args) {
        double income = 15000;
        double existingDebt = 1000;
        double creditScore = 760;
        boolean employmentStatus = true;

        if(income > 30000 && existingDebt < 5000 && creditScore > 700 && employmentStatus)
            System.out.println("Loan: Approved");
        else if(income > 10000 && income < 20000 && creditScore > 500 && employmentStatus)
            System.out.println("Loan: Manual Review");
        else 
            System.out.println("Loan: Rejected");
    }
}

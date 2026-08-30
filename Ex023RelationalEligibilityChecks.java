/*
Relational Eligibility Checks   [Basic Coding | Beginner]
For an applicant’s age, income and credit score, produce flags such as isAdult, meetsIncome and 
scoreWithinRange using relational operators.
Done when: Boundary values immediately below, at and above each threshold are tested.
 */

public class Ex023RelationalEligibilityChecks {
    public static void main(String[] args) {
    
        int age = 20;
        int income = 20000;
        int creditScore = 720;

        boolean isAdult = age >= 18;
        boolean meetsIncome = income >= 30000; 
        boolean scoreWithinRange = creditScore >= 500 && creditScore <= 800;

        if(isAdult && meetsIncome && scoreWithinRange == true)
            System.out.println("Success");
        else
            System.out.println("You are not able for this service");
    }
}


/*
< - less than
> - getter than
<= - equal or less than
>= - equal or getter than
== - equal
!= - not equal
 */

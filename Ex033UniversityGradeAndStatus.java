/*
University Grade and Status   [Scenario-Based | Beginner]
Convert a numeric mark to a letter grade and pass/fail status. Reject marks outside 0-100 with a clear message.
Done when: Tests cover invalid values and every exact grade boundary.
 */

public class Ex033UniversityGradeAndStatus {
    public static void main(String[] args) {
        double marks = 78;
        String grade;

        if (marks == 0 && marks <= 39)
            grade = "F(fail)";
        else if (marks >= 40 && marks <= 44)
            grade = "D(pass)";
        else if (marks >= 45 && marks <= 49)
            grade = "C(pass)";
        else if (marks >= 50 && marks <= 54)
            grade = "C+(pass)";
        else if (marks >= 55 && marks <= 59)
            grade = "B-(pass)";
        else if (marks >= 60 && marks <= 64)
            grade = "B(pass)";
        else if (marks >= 65 && marks <= 69)
            grade = "B+(pass)";
        else if (marks >= 70 && marks <= 74)
            grade = "A-(pass)";
        else if (marks >= 75 && marks <= 79)
            grade = "A(pass)";
        else if (marks >= 80 && marks <= 100)
            grade = "A+(pass)";
        else
            grade = "Invalid Marks";

        System.out.println("Result: " + grade);

    }
}

/*
Grade Statistics   [Build from Scratch | Intermediate]
Given an int[] of marks, calculate count, sum, average, pass count and fail count.
Done when: Boundary marks are handled correctly and average uses floating-point division.
*/

public class Ex68gradeStatistics {
    public static void main(String[] args) {
        int[] marks = { 30, 50, 80, 0, 70, 99 };
        int passMarks = 33;

        int count = marks.length;
        int sum = 0;
        int passCount = 0;
        int failCount = 0;

        for (int mark : marks) {
            sum += mark;

            if (mark >= passMarks) {
                passCount++;
            } else
                failCount++;
        }
        
        double average = (double) sum / count;

        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Pass Count: " + passCount);
        System.out.println("Fail Count: " + failCount);

    }
}

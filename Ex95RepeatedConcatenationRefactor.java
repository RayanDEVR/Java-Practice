/*
Repeated Concatenation Refactor   [Refactoring | Intermediate]
Refactor a loop that repeatedly creates report = report + line into a mutable builder approach. Keep output 
identical.
Done when: The builder is created once, appended inside the loop and converted/printed at the end.
*/

public class Ex95RepeatedConcatenationRefactor {
    public static void main(String[] args) {
        String[] lines = { "Line 1", "Line 2", "Line 3", "Line 4" };
        String report = "";

        for (String line : lines) {                 //creates multiple objects
            report = report + line + "\n";
        }
        System.out.println(report);


        StringBuilder reportBuilder = new StringBuilder();      //creates object once
        for (String line : lines) {
            reportBuilder.append(line).append("\n");
        }
        reportBuilder.toString();
        System.out.println(reportBuilder);
    }
}
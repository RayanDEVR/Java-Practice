/*
Monthly Performance Report   [Build from Scratch | Intermediate]
From 12 monthly revenue values, calculate annual total, average, count above average and the best month 
index/name using a parallel month-name array only for labels.
Done when: Results are correct and the revenue data remains in one array.
*/

public class Ex084MonthlyPerformanceReport {
    public static void main(String[] args) {
        double[] revenue = { 12000, 15000, 9000, 18000, 21000, 17000, 13000, 16000, 19000, 22000, 14000, 20000 };
        String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        
        System.out.println("=== Monthly Performance Report ===");
        for (int i = 0; i < revenue.length; i++) {
            System.out.println(monthNames[i] + "        " + ": " + revenue[i]);
        }
        double annualTotal = 0;
        for (double marks : revenue) {
            annualTotal += marks;
        }
        double average = annualTotal / revenue.length;


        String bestMonth = monthNames[0];
        double highestSalary = revenue[0];
        for (int i = 1; i < revenue.length; i++) {
            if (revenue[i] > highestSalary) {
                highestSalary = revenue[i];
                bestMonth = monthNames[i];
            }
        }

    System.out.println("Total Marks: " + annualTotal);
    System.out.println("Average: " + average);
    System.out.println("Highest Salary Month: " + highestSalary);
    System.out.println("Best Month: " + bestMonth);
    }
}

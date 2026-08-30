/*
Weekly Sales Total   [Basic Coding | Intermediate]
Store seven daily sales values in a double array. Calculate total and average with a loop.
Done when: The loop uses length, handles zero values and prints a verifiable total.
*/

public class Ex067WeeklySalesTotal {
    public static void main(String[] args) {
        double[] sales = { 1300.50, 1300.25, 1000.50, 1500.75 };
        double total = 0;

        for (int i = 0; i < sales.length; i++) {
            total += sales[i];
        }

        double average = total / sales.length;

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}

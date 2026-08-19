/*
Employee Gross Pay   [Scenario-Based | Beginner]
Calculate gross pay from regularHours, overtimeHours, hourlyRate and an overtime multiplier. At this level, 
assume the hours have already been separated.
Done when: At least three cases are tested, including no overtime and fractional hourly rates.
 */

public class Ex29employeeGrossPay {
    public static void main(String[] args) {
         double regularHours = 8;
         double overtimeHours = 4;
         double hourlyRate = 400;
         double overtimeMultiplier = 1.5;

         double regularPay = regularHours * hourlyRate;
         double overtimePay = overtimeHours * hourlyRate * overtimeMultiplier;
         double totalPayment = regularPay + overtimePay;

         System.out.println("Regular Pay: " + regularPay);
         System.out.println("Overtime Pay: " + overtimePay);
         System.out.println("Gross Pay: " + totalPayment);
    }
}

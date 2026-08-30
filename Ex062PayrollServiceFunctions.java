/*
Payroll Service Functions   [Build from Scratch | Intermediate]
Implement calculateRegularPay, calculateOvertimePay, calculateGrossPay and calculateNetPay. Keep every 
formula in one logical place.
Done when: A manual worked example matches program output and no method depends on console input.
*/


class PayrollService {
    public double calculateRegularPay(double regularHours, double hourRate) {
        return regularHours * hourRate;
    }

    public double calculateOvertimePay(double overtimeHour, double overtimeHourRate) {
        return overtimeHour * overtimeHourRate;
    }

    public double calculateGrossPay(double regularPay, double overtimePay) {
        return regularPay + overtimePay;
    }

    public double calculateNetPay(double grossPay, double taxPercent) {
        return grossPay - (grossPay * taxPercent / 100);
    }
}

public class Ex062PayrollServiceFunctions {
    public static void main(String[] args) {
        PayrollService pay = new PayrollService();
        
        double regularPay = pay.calculateRegularPay(8, 100);
        double overtimePay = pay.calculateOvertimePay(3, 50);
        double grossPay = pay.calculateGrossPay(regularPay, overtimePay);
        double netPay = pay.calculateNetPay(grossPay, 5);
        
        System.out.println("Regular Pay: " + regularPay);
        System.out.println("Overtime Pay: " + overtimePay);
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Net Pay: " + netPay);
         
    }
}

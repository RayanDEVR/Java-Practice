/*
Override Payroll Calculation   [Build from Scratch | Intermediate]
Create Employee.calculatePay and override it for HourlyEmployee and CommissionEmployee. Use @Override.
Done when: Each subtype computes pay with subtype-specific data and compiles with the annotation.
*/

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }
    public double calculatePay() {
        return 0;
    }
}

class HourlyEmployee extends Employee {
    int hour;
    double hourRate;

    public HourlyEmployee(String name, int hour, double hourRate) {
        super(name);
        this.hour = hour;
        this.hourRate = hourRate;
    }

    @Override
    public double calculatePay() {
        return hour * hourRate;
    }
}

class CommissionEmployee extends Employee {
    int salesAmmount;
    double commissionRate;

    public CommissionEmployee(String name, int salesAmmount, double commissionRate) {
        super(name);
        this.salesAmmount = salesAmmount;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay() {
        return salesAmmount * commissionRate;
    }
}

public class Ex114OverridePayrollCalculation {
    public static void main(String[] args) {
        Employee e1 = new HourlyEmployee("Rayan", 8, 100);
        Employee e2 = new CommissionEmployee("Samiul", 7, 200);

        System.out.println(e1.name + "-> pay: " + e1.calculatePay());
        System.out.println(e2.name + "-> pay: " + e2.calculatePay());
    }
}

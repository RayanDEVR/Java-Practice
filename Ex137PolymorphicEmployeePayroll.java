/*
Polymorphic Employee Payroll   [Scenario-Based | Advanced]
Create an abstract Employee and three pay implementations. Store them in Employee[] and calculate total 
payroll through one overridden method.
Done when: No type-based if chain is needed to calculate pay.
*/

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class HourlyEmployee extends Employee {
    double rate, hour;

    HourlyEmployee(String name, double rate, double hour) {
        super(name);
        this.rate = rate;
        this.hour = hour;
    }

    @Override
    double calculatePay() {
        return rate * hour;
    }
}

class SalariedEmployee extends Employee {
    double monthlySalary;

    SalariedEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculatePay() {
        return monthlySalary;
    }
}

class CommissionEmployee extends Employee {
    double base, sales, rate;

    CommissionEmployee(String name, double base, double sales, double rate) {
        super(name);
        this.base = base;
        this.rate = rate;
        this.sales = sales;
    }

    @Override
    double calculatePay() {
        return base + (sales * rate);
    }
}

public class Ex137PolymorphicEmployeePayroll {
    public static void main(String[] args) {
        Employee[] employees = {
            new HourlyEmployee("Rayan", 10000, 8),
            new SalariedEmployee("Samiul", 20000),
            new CommissionEmployee("Abdullah", 8000, 60000, 0.04)
        };

        double totalPayroll = 0;
        for (Employee e : employees) {
            double pay = e.calculatePay();
            System.out.println(e.name + " -> " + pay);
            totalPayroll += pay;
        }

        System.out.println("Total payroll: " + totalPayroll);
    }
}

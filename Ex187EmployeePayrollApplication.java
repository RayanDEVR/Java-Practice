/*
Employee Payroll Application [Mini Project | Project]
Create abstract Employee with SalariedEmployee, HourlyEmployee and CommissionEmployee. PayrollService 
computes polymorphic pay, handles invalid data and generates sorted payroll reports.
Done when: No type switch calculates pay; total/average payroll and highest-pay report are correct; equality is 
based on stable employee ID.
*/

import java.util.List;
import java.util.ArrayList;

abstract class Employee {
    String id;
    String name;
    
    Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    abstract double calculatePay();
}

class SalariedEmployee extends Employee {
    public double monthlySalary;
    
    SalariedEmployee(String id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }
    
    public double calculatePay() {
        return monthlySalary;
    }
}

class HourlyEmployee extends Employee {
    double hourlyRate;
    double hoursWorked;
    
    HourlyEmployee(String id, String name, double hourlyRate, double hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}

class CommissionEmployee extends Employee {
    double basicSalary;
    double commission;
    
    CommissionEmployee(String id, String name, double basicSalary, double commission) {
        super(id, name);
        this.basicSalary = basicSalary;
        this.commission = commission;
    }
    
    public double calculatePay() {
        return basicSalary + commission;
    }
}

class PayrollService {
    List<Employee> employees = new ArrayList<>();
    
    void addEmployee(Employee employee) {
        for (Employee e: employees) {
            if (e.id.equals(employee.id)) {
                System.out.println("Duplicate employee ID found. Rejected employee name: " + e.name);
                return;
            }
        }
        
        employees.add(employee);
    }
    
    double totalPayroll() {
        double total = 0;
        
        for(Employee e: employees) {
            total += e.calculatePay();
        }
        return total;
    }
    
    double averagePayroll() {
        if (employees.isEmpty()) {
            return 0;
        }
        
        return totalPayroll() / employees.size();
    }
    
    Employee highestPaidEmployee() {
        if (employees.isEmpty()) {
            return null;
        }
        
        Employee highest = employees.get(0);
        for (Employee e: employees) {
            if (e.calculatePay() > highest.calculatePay()) {
                highest = e;
            }
        }
        return highest;
    }
    
    void sortedPayrollReport() {
        employees.sort (
            (e1, e2) -> Double.compare(e1.calculatePay(), e2.calculatePay())
        );
        
        System.out.println("\nPayroll Report: ");
        for (Employee e : employees) {
            System.out.println(e.id + " | " + e.name + " | " + e.calculatePay());
        }
    }
}

public class Ex187EmployeePayrollApplication {
    
    public static void main(String[] args) {
     PayrollService payroll = new PayrollService();   
        
        payroll.addEmployee(new SalariedEmployee("E-101", "Rayan", 15000));
        payroll.addEmployee(new HourlyEmployee("E-102", "Samiul", 1000, 8));
        payroll.addEmployee(new CommissionEmployee("E-103", "Abdullah", 10000, 5000));
        payroll.addEmployee(new SalariedEmployee("E-101", "Radoan", 20000));
        
        System.out.println("Total Payroll: " + payroll.totalPayroll());
        System.out.println("Average Payroll: " + payroll.averagePayroll());
        
        Employee highest = payroll.highestPaidEmployee();
        System.out.println("Highest Paid Employee: " + highest.name + " | " + highest.calculatePay());
        
        payroll.sortedPayrollReport();
    }
}
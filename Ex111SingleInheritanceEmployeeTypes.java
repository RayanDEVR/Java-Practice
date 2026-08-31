/*
Single Inheritance: Employee Types   [Build from Scratch | Intermediate]
Create Employee with common identity fields and SalariedEmployee extending it 
with monthlySalary. Use inherited behavior and add salary-specific calculation.
Done when: The child is a valid Employee and common fields are not duplicated.
*/

class Employee {
    int id;
    String name;

    public void employeeIdentity(int id, String name) {
        this.id = id;
        this.name = name;
        
        System.out.println(id + " - " + name);
    }
}

class SalariedEmployee extends Employee {
    double salary;

    public void monthlySalary(double salary) {
        this.salary = salary;
        System.out.println("Monthly Salary: " + salary);
    }
    
    public void annualSaray() {
        System.out.println("Annual Salary: " + (salary * 12));
    }
}

public class Ex111SingleInheritanceEmployeeTypes {
    public static void main(String[] args) {
        SalariedEmployee emp = new SalariedEmployee();
        emp.employeeIdentity(101, "Rayan");
        emp.monthlySalary(20000);
        emp.annualSaray();
    }
}

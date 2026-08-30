/*
Parallel Arrays to Objects   [Refactoring | Intermediate]
Refactor separate arrays for employeeIds, names and salaries into Employee[]. Explain the inconsistency risk 
removed by the design.
Done when: One Employee object owns all related fields and reporting still works.
*/

class Employees {
    int empID;
    String name;
    double salary;

    public Employees(int empID, String name, double salary) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
    }

    public void salary() {
        System.out.println("ID: " + empID + ", Name: " + name + ", Salary: " + salary);
    }

}

public class Ex082ParallelArraysToObjects {
    public static void main(String[] args) {
        Employees[] employee = new Employees[3];
        employee[0] = new Employees(1001, "Rayan", 1500);
        employee[1] = new Employees(1002, "Samiul", 2000);
        employee[2] = new Employees(1003, "Radoan", 1000);
        for (Employees e : employee) {
            e.salary();
        }
    
    }

    
}

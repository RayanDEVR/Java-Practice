/* 
Static Method Boundaries   [Bug Fixing | Intermediate]
Repair a static method that directly accesses an instance field.
Choose whether to make the method instance based or pass/use an object,
and justify the design.
Done when: The fix compiles and reflects whether the behavior belongs
to one object or the class.
*/

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void getSalary(){
        System.out.println("Name: " + name + "; Salary: " + salary);
    }

}
public class Ex107StaticMethodBoundaries {
    public static void main(String[] args) {
        Employee emp = new Employee("Rayan", 15000);
        emp.getSalary();
    }
}

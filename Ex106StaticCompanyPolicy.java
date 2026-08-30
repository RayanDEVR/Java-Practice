/* 
Static Company Policy   [Scenario-Based | Intermediate]
Create Employee with instance id/name/salary and a static companyName shared
by all. Change companyName once and show its effect on existing objects.
Done when: Instance state remains independent while the class-level field 
is shared.
*/

class Employee {
    int id;
    String name;
    double salary;
    static String companyName = "Alpha Corp";

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String show() {
        return id + " - " + name + " - " + salary + " @" + companyName ;
    }

}

public class Ex106StaticCompanyPolicy {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Rayan", 12000);
        Employee emp2 = new Employee(102, "Samiul", 15000);
        
        System.out.println("--- Before Company Name Change---");
        System.out.println(emp1.show());
        System.out.println(emp2.show());


        System.out.println();
        System.out.println("--- After Company Name Change---");

        Employee.companyName = "NextGen Corp";
        System.out.println(emp1.show());
        System.out.println(emp2.show());

    }
}

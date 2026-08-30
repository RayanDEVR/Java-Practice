/*
Console Profile Card   [Build from Scratch | Beginner]
Print a neatly aligned five-line profile card containing a fictional employee ID, name, department, role and active 
status. Use escape characters only if they were encountered while writing output; otherwise use multiple println 
calls.
Done when: Output is readable, labels are consistent and the program has the correct entry structure.
 */

class Info {
    String id;
    String name;
    String department;
    String role;
    String status;

    public void show()
    {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Role: " + role);
        System.out.println("Status: " + status);
    }
}

public class Ex009ConsoleProfileCard {
    public static void main(String[] args) {
        Info em1 = new Info();
        em1.id = "EMP101";
        em1.name = "Abdullah Radoan";
        em1.department = "Sales";
        em1.role = "Executive";
        em1.status = "Active";

        em1.show();
    }
}

/*
Jagged Department Teams   [Scenario-Based | Intermediate]
Model departments with different team sizes using a jagged int array of employee IDs. Print department size 
and members.
Done when: Traversal never assumes all rows have equal length.
*/

public class Ex76jaggedDepartmentTeams {
    public static void main(String[] args) {
        int[][] departmentTeam = {
                { 1001, 1002, 1003, 1004 },
                { 2002, 2003, 2005 },
                { 3001 }
        };

        for (int dept = 0; dept < departmentTeam.length; dept++) {
            System.out.println("Department " + (dept + 1) + " size: " + departmentTeam[dept].length);
            System.out.print("Employee ID: ");
            
            for (int empID : departmentTeam[dept]) {
                System.out.print(empID + "  ");
            }
            System.out.println();
            System.out.println();
        }

    }
}

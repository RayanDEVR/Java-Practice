/*
Student Results Object Array   [Scenario-Based | Intermediate]
Create Student objects with roll, name and mark, store them in Student[], and print pass/fail plus the class 
average.
Done when: No parallel name/mark arrays are used and null slots are prevented or handled.
*/

class Student {
    String name;
    int roll;
    int marks;
    String status;

    public Student(String name, int roll, int marks, String status) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        this.status = status;
    }

    public void result() {
        System.out.println("Name: " + name + "; Roll: " + roll + "; Mark: " + marks + "-" + status);
    }
}

public class Ex80studentResultsObjectArray {
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student("Rayan", 1, 80, "");
        students[1] = new Student("Samiul", 5, 25, "");
        students[2] = new Student("Radoan", 4, 90, "");
        students[3] = new Student("Abdullah", 7, 30, "");

        
        int countPass = 0;
        int countFail = 0;
        int total = 0;
        
        for (Student s : students) {
            s.status = s.marks >= 33 ? "Pass" : "Fail";
            s.result();
            if (s.marks >= 33)
                countPass++;
            else
                countFail++;

            total += s.marks;
        }
        double average = (double)total / students.length;
        System.out.println("Pass: " + countPass);
        System.out.println("Fail: " + countFail);
        System.out.println("Calss Average: " + average);
    }
}

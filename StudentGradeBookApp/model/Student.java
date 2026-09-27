package StudentGradeBookApp.model;

public class Student {
    public int id;
    public String name;
    public double marks;
    public char grade;
    public String status;
    
       
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        
         if(marks < 40) {
            grade = 'F';
             status = "FAIL";
         }
        else if (marks >= 40 && marks < 60) {
            grade = 'C';
        status = "PASS";
    } 
        else if (marks >= 60 && marks < 80) {
                grade = 'B';
                status = "PASS";
        }
        else if (marks >= 80 && marks <= 100) {
                    grade = 'A';
                    status = "PASS";
    }
    }
}

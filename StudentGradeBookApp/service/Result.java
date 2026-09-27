package StudentGradeBookApp.service;

import StudentGradeBookApp.model.Student;

public class Result {
    public void getResult(Student s) {
        if (s.marks < 0 || s.marks > 100) {
            System.out.println("Invalid marks " + s.marks + " for Student#" + s.id);
            return;
        }
        System.out.println("Student#" + s.id + ": " + s.name + "; " + "marks: " + s.marks + "; Grade: " + s.grade + ", " + s.status);
    }
    
}
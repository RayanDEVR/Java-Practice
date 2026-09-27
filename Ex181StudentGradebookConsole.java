/*
Student Gradebook Console   [Mini Project | Project]
Build packages model, service and app. Student has id/name/marks, GradeService validates 0-100, calculates 
grade/status and produces class summary. Store students in ArrayList, reject duplicate IDs with a Set or lookup 
Map, sort/report with Comparator/streams.
Done when: Required flows: add student, view one, list all, update mark, class average, pass/fail counts, top-to
bottom report, invalid-input recovery and readable toString.
*/

import StudentGradeBookApp.model.Student;
import StudentGradeBookApp.service.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Ex181StudentGradebookConsole {
    
    public static void main(String[] args) {
        Comparator<Student> com = (i,j) -> Integer.compare(i.id, j.id);
       
       List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Rayan", 80));
        students.add(new Student(3, "Samiul", 20));
        students.add(new Student(2, "Radoan", 40));
        students.add(new Student(5, "Abdullah", 130));
        students.add(new Student(3, "Tania", 70));
        students.add(new Student(4, "Sani", -10));
       
       Set<Integer> ids = new HashSet<>();
       List<Student> validStudents = new ArrayList<>();
       
       for(Student s : students) {
          if(!ids.add(s.id)) {
             System.out.println("Duplicate ID found. Student rejected, name " + s.name);
             continue;
          }
          validStudents.add(s);
       }
      
       Collections.sort(validStudents, com);
       
       Result result = new Result();
       
       double totalMarks = 0;
       int validMarkCount = 0;
       for(Student s: validStudents) {
          result.getResult(s);
          if(s.marks >= 0 && s.marks <= 100) {
             totalMarks += s.marks;
             validMarkCount++;
          }
       }
       
       double average = totalMarks / validMarkCount;
       System.out.println("Average marks: " + average);
    }
    
}
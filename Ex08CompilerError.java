/*
Compiler Error Triage   [Bug Fixing | Beginner]
A 15-line program contains six independent syntax errors. Fix only the first compiler error, compile again, and 
repeat until clean. Record the order in which the compiler revealed them.
Done when: The final code compiles and the student demonstrates disciplined first-error-first debugging.
 */

class Student {
   public void show(String name, int roll) {
    System.out.println(name + "(" + roll + ")");
   }
}

public class Ex08CompilerError {
    public static void main(String[] args) {
        Student s = new Student();
        s.show("Rayan", 10);
    }
}


/* fixing errors
1st - public show() -> public void show()
2nd - string -> String
3rd - Int -> int
4th - System.outprintln(); -> System.out.println();
5th - String() -> String[]
6th - s.show() -> s.show();*/
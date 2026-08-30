/*
Read an Unfamiliar Tiny Program   [Code Reading | Beginner]
Annotate a supplied 12-line Java program line by line: class declaration, main method, statements, strings, 
punctuation and execution order. Then rewrite it with clearer class and message names.
Done when: Every executable line is explained and the refactored program behaves identically.
*/

class Student {
   public void show(String name, int roll) {
    System.out.println(name + "(" + roll + ")");
   }
}

public class Ex10CodeReading {
    public static void main(String[] args) {
        Student s = new Student();
        s.show("Rayan", 10);
    }
}


/*
line 1 - class declaration
line 2 & 3 - making a method with statement
line 4 & 5 - close the method and the class with brace
line 7 - main class
line 8 - main method
line 9 & 10 - print statement
line 11 & 12 - close the main method and class */

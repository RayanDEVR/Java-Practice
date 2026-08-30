/*
Pass-by-Value Investigation   [Output Prediction | Intermediate]
Predict a method that changes an int parameter, another that reassigns an object parameter, and another that 
changes a field through the parameter reference. Draw stack/reference diagrams.
Done when: Predictions distinguish reassigning a local reference from mutating the referenced object.
 */

class Student {
    int mark;

    public void change(Student s) {
        s.mark=90;
    }
}

public class Ex057PassByValueInvestigation {
    public static void main(String[] args) {

        Student s = new Student();
        s.mark = 50;                        //50
        s.change(s);                        //90

        System.out.println(s.mark);
    }
}

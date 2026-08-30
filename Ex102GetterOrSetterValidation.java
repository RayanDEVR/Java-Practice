/*
Getter/Setter Validation   [Bug Fixing | Intermediate]
A Student class exposes public mark and accepts -20 or 130. Make the field private and validate through a setter 
or constructor.
Done when: Every Student instance has a mark within the chosen valid range.
*/

class Student {
    private String name;
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public void result() {
        System.out.println(name + ": " + mark);
    }
}

public class Ex102GetterOrSetterValidation {
    public static void main(String[] args) {
        Student s1 = new Student("Rayan", 90);
        Student s2 = new Student("Samiul", 50);
        Student s3 = new Student("Abdullah", 40);

        s1.result();
        s2.result();
        s3.result();
    } 
}

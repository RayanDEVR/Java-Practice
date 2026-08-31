/*
Multilevel Inheritance Trace   [Output Prediction | Intermediate]
Create Person -> Employee -> Manager constructors that print messages. Predict 
constructor execution when Manager is created and explain implicit super calls.
Done when: The output order and constructor-chain explanation are correct.
*/

class Person{
    public Person(){
        System.out.println("Person Constructor.");
    }
}

class Employee extends Person{
    public Employee(){
        super();
        System.out.println("Employee Constructor.");
    }
}

class Manager extends Employee{
    public Manager(){
        super();
        System.out.println("Manager Constructor.");
    }
}

public class Ex112MultilevelInheritanceTrace {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}

/* 
Output:
Person Constructor.
Employee Constructor.
Manager Constructor.
*/
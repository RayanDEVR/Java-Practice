/*
this() and super() Constructor Chain   [Code Completion | Intermediate]
Complete overloaded constructors so one constructor delegates with this(), 
while the child calls an appropriate parent constructor with super().
Done when: Constructor delegation is the first statement and initialization occurs exactly once.
*/

class Vehicle {
    String type;
    int wheels;

    public Vehicle(String type, int wheels) {
        this.type = type;
        this.wheels = wheels;
        System.out.println("Vehicle initialized: " + type + " with " + wheels + " wheels.");
    }

}

class Car extends Vehicle {
    String model;

    public Car(String model, int wheels) {
        super("Car", 4);
        this.model = model;
    }

    public Car(String model) {
        this("Generic", 4);
    }
}

public class Ex113ThisAndSuperConstructorChain{
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", 2);
        Car c2 = new Car("Civic");

        System.out.println(c1.model + "->" + c1.type + ", wheels: " + c1.wheels);
        System.out.println(c2.model + "->" + c2.type + ", wheels: " + c2.wheels);
    
    }
}
/*
Is-a or Has-a Review   [Refactoring | Advanced]
A Car extends Engine design exists only for code reuse. Replace it with a valid relationship and explain why Car is 
not substitutable for Engine.
Done when: The final model uses composition for has-a and inheritance only for an actual is-a relation.
*/

class Engine {
    public void start() {
        System.out.println("Engine starting...");
    }
}

// class Car extends Engine {           a car Is not an engine, it Has an engine
// }

class Car {
    private Engine engine;

    public Car() {
        this.engine = new Engine();
    }

    public void run() {
        engine.start();
        System.out.print("Car is moving...");
    }
}

public class Ex123IsAOrHasAReview {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();
    }
}

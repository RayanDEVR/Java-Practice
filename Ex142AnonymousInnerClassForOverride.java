/*
Anonymous Inner Class for Override   [Output Prediction | Advanced]
Create a concrete object from an abstract class using an anonymous inner class. Predict which implementation 
executes and identify the generated object’s usable reference type.
Done when: The abstract method is implemented inline and behavior is correctly dispatched.
*/

abstract class Shape {
    abstract double area();
}

public class Ex142AnonymousInnerClassForOverride {
    public static void main(String[] args) {
        Shape circle = new Shape() {
            double radius = 5;
            @Override 
            public double area() {
                return (Math.PI * radius * radius);
            }
        };

        System.out.println("Area of the circle: " + circle.area());
    }
}

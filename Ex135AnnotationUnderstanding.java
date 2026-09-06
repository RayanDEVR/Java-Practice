/*
Annotation Understanding   [Code Reading | Advanced]
Use @Override and @FunctionalInterface in a small program, then intentionally violate each contract and record 
the compiler’s help. Explain annotations as metadata, not ordinary method calls.
Done when: The student states what each annotation checks or communicates.
*/

class Animal {
    public void sound() {
        System.out.println("Some sound...");
    };
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barking...");
    }

    // @Override                   //Animal class doesn't have noise() method
    // public void noise() {
    //     System.out.println("Making noise...");
    // }
}

@FunctionalInterface
interface Greeter {
    void greet(String name);
}

// @FunctionalInterface             //FunctionalInterface contains only one method
// interface BrokenGreeter {
//     void greet(String name);
//     void farewell(String name);
// }

public class Ex135AnnotationUnderstanding {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();

        Greeter g = name -> System.out.println("Hello " + name);
        g.greet("Rayan");
    }
}

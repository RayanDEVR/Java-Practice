/*
Anonymous Object Use   [Code Reading | Intermediate]
Call a stateless utility-like object method using an anonymous object, 
then explain why it cannot conveniently be reused. Refactor to a named 
reference when two calls are required.
Done when: The student can identify the limited one-use context for an 
anonymous object.
*/

class Calculator {
    public int square(int a) {
        return a * a;
    }
}

public class Ex109AnonymousObjectUse {
    public static void main(String[] args) {

        System.out.println(new Calculator().square(9));    //Anonymous object

        Calculator calc = new Calculator();
        System.out.println(calc.square(4));
        System.out.println(calc.square(3));
    }
}

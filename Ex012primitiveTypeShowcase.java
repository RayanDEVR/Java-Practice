/*
 Primitive Type Showcase   [Basic Coding | Beginner]
Create one valid variable of every primitive type and print its value with a label. Change selected literals to 
intentionally invalid values, observe the compiler errors, then restore them.
Done when: All eight primitive types are represented and at least three range/type errors are documented.
*/

public class Ex12primitiveTypeShowcase {
    public static void main(String[] args) {
        byte b= 200;
        short s= 40000; //wrong, short's range: -128 - 127
        int i= 12000;
        long l= 9000000; //wrong, long value works with 'l'; correct: 9000000l
        float f= 3.12; //need 'f' to specify float type; correct: 3.12f
        double d= 4.23;
        char c= 'A';
        boolean flag= true;

        System.err.println("byte: " + b);
        System.err.println("short: " + s);
        System.err.println("int: " + i);
        System.err.println("long: " + l);
        System.err.println("float: " + f);
        System.err.println("double: " + d);
        System.err.println("char: " + c);
        System.err.println("boolean: " + flag);
    }
}

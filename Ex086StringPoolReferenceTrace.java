/* 
String Pool Reference Trace   [Output Prediction | Intermediate]
Predict == and equals results for two identical string literals, a new 
String with the same content and an alias reference. Draw the references 
before running.
Done when: The explanation distinguishes object identity from content equality.
*/

public class Ex086StringPoolReferenceTrace {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
        String c = new String("hello");
        String d = a;       //alias

        System.out.println(a == b);         //true
        System.out.println(a == c);         //false
        System.out.println(a.equals(c));    //true
        System.out.println(a == d);         //true
    }
}

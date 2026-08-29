/*
String Alias Investigation   [Output Prediction | Intermediate]
Trace two references to one String and then reassign one after concatenation. Explain why the other reference 
still sees the original text.
Done when: The reference diagram and output prediction agree.
*/

public class Ex96StringAliasInvestigation {
    public static void main(String[] args) {
        String original = "Hello";
        String alias = original;
        original = original + " World";

        System.out.println(original);       //Hello World
        System.out.println(alias);          //Hello
    }
}

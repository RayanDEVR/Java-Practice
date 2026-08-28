/* 
Immutable Concatenation   [Output Prediction | Intermediate]
Predict the value of a String after calling concat without assignment, then after assigning the returned value. 
Explain what immutability means and does not mean.
Done when: The original object is not described as internally modified.
*/

public class Ex88immutableConcatenation {
    public static void main(String[] args) {
        String a = "Hello";
        System.out.println(a);          //Hello

        a = a.concat(" World");     //Hello World
        System.out.println(a);
    }
}

/*
Narrowing and Data Loss   [Output Prediction | Beginner]
Predict the results of casting double 129.95 to int and int 130 to byte. Run the program and explain truncation 
and overflow/wraparound behavior in plain language.
Done when: Both predictions and explanations are correct; the student states why a cast does not guarantee a 
meaningful value.
 */

public class Ex17NarrowingAndDataLoss {
    public static void main(String[] args) {
        double d = 129.95;
        int i = (int) d;
        byte b = (byte)i;

        System.out.println(i);
        System.out.println(b);
    }
}


//129.95 -> 129; Decimal part is cut. It is called Truncation
//129 -> -127; 129 is out of the range of byte(-128 - 127). That's why an overflow occured

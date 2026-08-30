/*
Widening Conversion   [Code Completion | Beginner]
Complete a program that safely moves byte to short to int to long to float to double. Print each result and 
identify which assignments require no explicit cast.
Done when: All safe widening assignments compile and the direction of widening is explained.
 */

public class Ex016WideningConversion {
    public static void main(String[] args) {
        byte b = 23;
        short s = b;            //no casting needed
        int i = s;              //no casting needed
        long l = i;             //no casting needed
        float f = l;            //no casting needed
        double d = f;           //no casting needed
        
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }
}


//no casting is needed if you convert normal value to point value
//casting is needed if you convert point value to normal value

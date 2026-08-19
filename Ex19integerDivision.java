/*
Integer Division Trap   [Output Prediction | Beginner]
Predict 7 / 2, 7 / 2.0, (double) 7 / 2 and (double) (7 / 2). Relate the results to calculating an average score.
Done when: All four values are explained and the average calculation retains the fraction.
 */

public class Ex19integerDivision {
    public static void main(String[] args) {
        System.out.println(7/2);                //case 01
        System.out.println(7/2.0);              //case 02
        System.out.println((double)7/2);        //case 03
        System.out.println((double)(7/2));      //case 04
    }
}


/*
case 01 - here both 7 and 2 are integer value. that's why the result 3.5 - > 3
case 02 - here 7 is an integer and 2.0 is a double value. So, the result is 3.5
case 03 - here 7 is a double and 2 is an integer value. So, the result is 3.5
case 04 - here both 7 and 2 is integer values, but the result is a double value. So, 7/2 -> 3 -> 3.0
 */
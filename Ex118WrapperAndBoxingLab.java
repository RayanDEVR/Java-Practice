/*
Wrapper and Boxing Lab   [Code Completion | Intermediate]
Convert primitive int to Integer through boxing, back through unboxing, and parse a numeric String using the 
wrapper operation shown in the lesson. Handle only valid text here.
Done when: Values remain equal and primitive versus object roles are explained.
*/

public class Ex118WrapperAndBoxingLab {
    public static void main(String[] args) {
        int primitiveNum = 10;
        Integer boxedNum = primitiveNum; //auto-boxing
        
        int unboxedNum = boxedNum; //auto-unboxing
        System.out.println(unboxedNum);
        System.out.println(primitiveNum == unboxedNum);

        String num = "30";
        int num1 = Integer.parseInt(num);
        System.out.println(num1 + 10);
    }
}

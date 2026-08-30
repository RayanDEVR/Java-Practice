/*
Array Defaults and Initialization   [Output Prediction | Intermediate]
Create int, double, boolean and object-reference arrays without assigning elements. Predict and print their 
defaults. Explain why local primitive variables behave differently.
Done when: Predictions are correct and null is recognized as the default for reference slots. 
*/


class Item {}

public class Ex066ArrayDefaultsAndInitialization {
    public static void main(String[] args) {
        int[] intArr = new int[3];
        double[] doubleArr = new double[3];
        boolean[] booleanArr = new boolean[3];
        Item[] itemArr = new Item[3];

        System.out.println(intArr[2]); //0
        System.out.println(doubleArr[2]); //0.0
        System.out.println(booleanArr[2]); //false
        System.out.println(itemArr[2]); //null
    }
}


/*
By default JVM sets the value of Array. For numbers, it's 0, false for boolean and null for Referance Type.
*/

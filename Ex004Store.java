/*
Filename and Class-Name Investigation   [Output Prediction | Beginner]
Predict what happens when a file named Store.java contains public class Shop. Test the prediction. Repeat with a 
non-public class Shop and record the difference.
Done when: The report states when the filename must match the class name and includes actual compiler 
behavior.
*/


/*
public class Shop {
    public static void main(String[] args)
        System.out.println("Welcome");
    } 
}
*/

class Shop {
    public static void main(String[] args) {
        System.out.println("Welcome");
    }
}


//when your class is public, the file name and the class name must be same
//when your class is not public, the file name and the class name must not be same

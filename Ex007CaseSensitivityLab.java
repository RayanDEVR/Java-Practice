/*
Case Sensitivity Lab   [Output Prediction | Beginner]
Create small variants using system instead of System, String versus string, Main versus main and println versus 
Println. Predict compile success first, then test each.
Done when: A table records prediction, actual result and corrected spelling for every case.
*/

public class Ex007CaseSensitivityLab {
    // public static void Main(String[] args) {         wrong format
    //     string name = "Rayan";
    //     system.out.Println(name);
    // }

    public static void main(String[] args) {
        String name = "Rayan";
        System.out.println(name);
    }
}


/*
Code          Result                 Correct Form
Main()        Runtime error          main()
string        Compile time error     String
Println       Compile time error     println
 */

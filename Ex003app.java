/*
Repair a Broken Entry Point     [Bug Fixing | Beginner]
Fix a program containing public class app, Public Static Void Main(String args), a missing semicolon and 
mismatched braces. List every compiler-facing defect before changing it.
Done when: The repaired program compiles, and each fix is connected to a Java rule.
*/

public class Ex03app
// {                                              wrong
//     Public Static Void Main(String args)
//     {
//       System.out.println("Hello")
//     

{                                                   //right
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

/*
    wrong       -       right
    Public              public
    Static              static
    Void                void
    Main                main
    [] missing          []
    ; missing           ;
    incomplete class    completed with }
 */

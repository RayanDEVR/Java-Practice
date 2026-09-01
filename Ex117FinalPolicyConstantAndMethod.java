/*
final Policy Constant and Method   [Scenario-Based | Intermediate]
Use final for a fixed tax rate, a method that must not be overridden, and a class that must not be extended. 
Explain the three distinct meanings.
Done when: Each use compiles and is connected to an explicit design rule.
*/

class SecurityPolicy {
    final double taxRate = 0.75;

    final public void show() {
        System.out.println("TAX_RATE constant = " + taxRate);
    }
}

final class Demo extends SecurityPolicy {
    // public void show() {                     //final method stop overriding
    //     System.out.println("in show Demo");
    // }
}

// class FinalDemo extends Demo {               //final class cannot be extended
    
// }

public class Ex117FinalPolicyConstantAndMethod {
    public static void main(String[] args) {
        SecurityPolicy s = new SecurityPolicy();
        // s.taxRate = 0.5;                     //final variable cannot be changed
        s.show();
    }
}

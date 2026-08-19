/*
 Method Naming and Contract Review   [Refactoring | Intermediate]
Rename methods such as doIt, calc, process and check so their intent is clear. Rewrite comments as 
input/output contracts rather than narrating syntax.
Done when: A reader can predict each method’s role from its name and signature. 
*/


class unclearMethod {
    public double calc(double a, double b) {
        return a * b * 0.1;
    }

    public boolean check(int x) {
        return x >= 18;
    }

    public void doIt(String name, double amt) {
        System.out.println(name + " paid " + amt);
    }
}


class clearMethod {
    public double calculateTax(double price, int quantity) {
        return (price * quantity) * 0.1;
    }

    public boolean isAdult(int age) {
        return age >= 18;
    }

    public void paymentConfirmation(String name, double paidAmmount) {
        System.out.println(name + " paid " + paidAmmount);
    }
}

public class Ex63methodNamingAndContractReview {
    public static void main(String[] args) {
        
    }
}

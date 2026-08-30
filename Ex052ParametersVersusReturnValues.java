/*
Parameters Versus Return Values   [Code Reading | Intermediate]
Compare methods that print a tax value, return a tax value and modify a field. Explain which is most reusable for 
a billing service and why.
Done when: The selected design can be reused in a larger calculation without copying logic.
 */

class Calculate {
    public void printTax(double amount) {
        System.out.println("Total Tax: " + (amount * 0.1));
    }

    public double returnTax(double amount) {
        return amount * 0.1;
    }
}

class Mutate{
    double tax;

    void applyTax(double amount) {
        this.tax = amount * 0.1;

        System.out.println("Total Tax: " + tax);
    }
}


public class Ex052ParametersVersusReturnValues {
    public static void main(String[] args) {
        Calculate tax = new Calculate();
        tax.printTax(1200);
        double a =tax.returnTax(1200);
        
        Mutate tax1 = new Mutate();
        tax1.applyTax(1200);

        System.out.println("Total Tax: " + a);
    }
}

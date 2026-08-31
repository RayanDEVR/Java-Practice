/*
Static Initialization Block   [Code Reading | Intermediate]
Create a class whose static block initializes a shared tax rate and prints a one-time message. Construct several 
objects and predict execution order.
Done when: The block runs once per class loading in the observed program, before object construction output.
*/

class TaxConfig {
    static double taxRate;
    int id;

    static {
        taxRate = 0.75;
        System.out.println("[Static Block] TaxConfig loaded, taxRate set to " + taxRate);
    }

    public TaxConfig(int id) {
     
        this.id = id;
        System.out.println("[Constractor] TaxConfig object #" + id + " created.");
    }
}

public class Ex108StaticInitializationBlock {
    public static void main(String[] args) {
        TaxConfig t1 = new TaxConfig(1);
        TaxConfig t2 = new TaxConfig(2);
        TaxConfig t3 = new TaxConfig(3);

    }
}

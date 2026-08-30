/*
 Null Slot Failure   [Bug Fixing | Intermediate]
A Product[5] array contains only three constructed objects, but a loop dereferences all five. Diagnose and fix it in 
two ways: complete initialization and defensive null checking.
Done when: Both fixes run, and the preferred fix is justified for a known fixed dataset.
*/

class Product {
    String name;
    public Product(String name) { this.name = name; }
}

public class Ex081NullSlotFailure {
    public static void main(String[] args) {
        System.out.println("--- BUGGY VERSION ---");
        Product[] products = new Product[5];
        products[0] = new Product("Pen");
        products[1] = new Product("Book");
        products[2] = new Product("Eraser");

        for (Product p : products) {
            try {
                System.out.println(p.name);
            } catch (NullPointerException e) {
                System.out.println("Caught NullPointerException at an uninitialized slot: " + e.getClass().getSimpleName());
            }
        }
        
        System.out.println();
        System.out.println("--- FIX-1: Complete Initialization ---");
        Product[] fixed1 = new Product[5];
        fixed1[0] = new Product("Pen");
        fixed1[1] = new Product("Book");
        fixed1[2] = new Product("Eraser");
        fixed1[3] = new Product("Marker");
        fixed1[4] = new Product("Pencil");

        for (Product p : fixed1) {
            System.out.println(p.name);
        }

        System.out.println();
        System.out.println("--- FIX-2: Defensive Null Checking ---");
        Product[] fixed2 = new Product[5];
        fixed2[0] = new Product("Pen");
        fixed2[1] = new Product("Book");
        fixed2[2] = new Product("Eraser");

        for (Product p : fixed2) {
            if(p != null)
                System.out.println(p.name);
            else {
                System.out.println("(Skipped empty slot)");
            }
        }
    }
}

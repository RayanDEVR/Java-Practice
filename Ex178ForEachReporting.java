/*
forEach Reporting   [Refactoring | Advanced]
Refactor a simple collection-printing loop to forEach with a lambda. Keep a traditional loop for logic that 
becomes less readable and explain the choice.
Done when: Lambda syntax is correct and readability—not novelty—drives the decision.
*/

import java.util.Arrays;
import java.util.List;

public class Ex178ForEachReporting {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("Chair", "Table", "Book");


        System.out.println("--- Before: traditional loop for simple printing ---");
        for (String p: products){
            System.out.println("Product: " + p);
        }
        
        System.out.println();
        System.out.println("--- After: forEach for lambda ---");
        products.forEach(p -> System.out.println("Product: " + p));
    } 
}

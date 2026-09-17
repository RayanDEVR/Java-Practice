/* 
Sorted Stream Business Report [Scenario-Based | Advanced]
From Product objects, use a stream pipeline limited to filter, sorted, map/forEach or reduce as taught to report 
in-stock products ordered by price and total their stock/value with suitable simple mappings.
Done when: The pipeline is single-use, has no unsafe side effects and matches a manually verified result.
*/
 
import java.util.Comparator;
import java.util.List;

class Product{
    String name;
    double price;
    int stock;
    
    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class Ex180SortedStreamBusinessReport {
    
    public static void main(String[] args) {
        List<Product> products = List.of(
        new Product("Pen", 10, 4),
        new Product("Book", 50, 5),
        new Product("Pencil", 5, 10),
        new Product("Marker", 30, 0),
        new Product("Board", 90, 4)
        );
        
        System.out.println("In-stock products sorted by price");
        products.stream()
        .filter(p -> p.stock > 0)
        .sorted(Comparator.comparingDouble(p -> p.price))
        .forEach(p -> System.out.println(p.name + ": $" + p.price));
        
        
        double totalInventoryValue = products.stream()
        .filter(p -> p.stock > 0)
        .map(p -> p.price * p.stock)
        .reduce(0.0, Double::sum);
        
        System.out.println("Total in-stock inventory value: $" + totalInventoryValue);
        
    }
}
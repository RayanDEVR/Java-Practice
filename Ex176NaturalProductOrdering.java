/*
Natural Product Ordering   [Build from Scratch | Advanced]
Make Product implement Comparable using one natural field such as productId or price, then sort a list with 
Collections.sort. Document the chosen natural order.
Done when: compareTo is consistent enough for the supplied examples and sorting matches the stated order.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Product implements Comparable<Product>{
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override 
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }
}


public class Ex176NaturalProductOrdering {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mouse", 800));
        products.add(new Product("Monitor", 1800));
        products.add(new Product("Keyboard", 700));

        System.out.println("--- Before sorting ---");
        for (Product p : products) {
            System.out.println(p.name + ": " + p.price);
        }

        Set<Product> sortedproducts = new TreeSet<>();
        sortedproducts.add(new Product("Mouse", 800));
        sortedproducts.add(new Product("Monitor", 1800));
        sortedproducts.add(new Product("Keyboard", 700));

        System.out.println();
        System.out.println("--- After sorting ---");
        for (Product p : sortedproducts) {
            System.out.println(p.name + ": " + p.price);
        }
    }
}

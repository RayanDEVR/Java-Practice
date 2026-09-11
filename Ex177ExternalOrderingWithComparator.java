/*
External Ordering with Comparator   [Build from Scratch | Advanced]
Create Comparator strategies/lambdas for Product by price and by stock. Sort separate copies or restore data 
between runs.
Done when: The Product class can be ordered in multiple ways without changing its natural order each time.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    String name;
    double price;
    int stock;

    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return "Product: " + name + "(price: " + price + ", stock: " + stock + ")";
    }
}

public class Ex177ExternalOrderingWithComparator {
    public static void main(String[] args) {
        List<Product> byPrice = new ArrayList<>();
        byPrice.add(new Product("Monitor", 12000, 50));
        byPrice.add(new Product("Mouse", 1000, 20));
        byPrice.add(new Product("Keyboard", 100, 30));

        List<Product> byStock = new ArrayList<>(byPrice);

        Comparator<Product> priceComparator = (a, b) -> Double.compare(a.price, b.price);
        Comparator<Product> stockComparator = (a, b) -> Integer.compare(a.stock, b.stock);

        byPrice.sort(priceComparator);
        byStock.sort(stockComparator);

        System.out.println("Sorted by price: " + byPrice);
        System.out.println("Sorted by stock: " + byStock);
    }
}

/*
Product Label Refactor   [Refactoring | Intermediate]
Replace scattered concatenation across main with Product.toString after Object methods have been introduced 
conceptually in the course progression. For this exercise, first write the desired label format, then implement it.
Done when: Printing a Product directly produces the chosen readable representation.
*/

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + id + "]" + name + ": $" + price;
    }
    
}

public class Ex98ProductLabelRefactor {
    public static void main(String[] args) {
        Product p1 = new Product(101, "SmartPhone", 100);
        Product p2 = new Product(102, "Laptop", 1200);

        System.out.println(p1);
        System.out.println(p2);
    }
}

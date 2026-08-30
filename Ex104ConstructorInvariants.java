/*
Constructor Invariants   [Scenario-Based | Intermediate]
Design Product constructors so id and name are mandatory, price/stock
cannot be negative, and an optional constructor supplies zero stock.
Done when: No constructor creates an invalid Product and overloads do not
duplicate validation unnecessarily.
*/

class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;

        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name is mandatory");
        if (price < 0 || stock < 0)
            throw new IllegalArgumentException("Price/stock cannot be negative");
    }

    public String toString() {
        return id + " - " + name + ": " + price + ", Stock: " + stock;

    }
}

public class Ex104ConstructorInvariants {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Chair", 1200, 10);
        Product p2 = new Product(102, "Table", 1500, 20);

        System.out.println(p1);
        System.out.println(p2);

        try {
            Product p3 = new Product(103, null, 1220, 30);
            System.out.println(p3);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Rejected as expected: " + e.getMessage());
        }
    }
}

/*
Value Equality for Product   [Build from Scratch | Intermediate]
Define Product equality based on immutable productId and implement a consistent hashCode. Demonstrate 
equal-but-distinct objects.
Done when: equals is reflexive in tests, null/type-safe, and equal products produce the same hash code.
*/

class Product {
    private final String productId;
    private String name;

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }
}

public class Ex120ValueEqualityForProduct {
    public static void main(String[] args) {

        Product p1 = new Product("SKU-101", "Chair");
        Product p2 = new Product("SKU-101", "Table");
        Product p3 = new Product(null, "Bed");

        System.out.println("p1.equas(p1) [reflexive]: " + p1.equals(p1));
        System.out.println("p1.equas(p2) [different id, same name]: " + p1.equals(p2));
        System.out.println("p1.equas(p3) [different id]: " + p1.equals(p3));
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode()));
    }
}

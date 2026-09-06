/*
Object Contract in Hash-Based Collections Preview   [Code Reading | Advanced]
Create two equal Product objects and predict what should happen when they are later put in a Set. Connect 
equals/hashCode consistency to uniqueness without implementing untaught internals.
Done when: The explanation states why equal objects need equal hash codes.
*/

import java.util.Objects;

class Product {
    private int productId;
    private String name;

    Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Product))
            return false;

        Product other = (Product) obj;
        return productId == other.productId;
    }

    public int hashCode() {
        return Objects.hashCode(productId);
    }
}

public class Ex136ObjectContractInHashBasedCollectionsPreview {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Computer");
        Product p2 = new Product(101, "Chair");

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());
        System.out.println("Equal objects should have equal hash codes.");
    }
}

/*
Readable Product toString   [Refactoring | Intermediate]
Override toString for Product so logs/catalogues show id, name, price and stock. Compare output before and 
after.
Done when: Direct printing is readable and does not expose an accidental class@hash-like default 
representation.
*/

class ProductBefore {
    String id;
    String name;
    double price;
    int stock;

    public ProductBefore(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class ProductAfter {
    String id;
    String name;
    double price;
    int stock;

    public ProductAfter(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product[id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + "]"; 
    }
}

public class Ex119ReadableProductToString {
    public static void main(String[] args) {
        ProductBefore before = new ProductBefore("P1", "Table", 1200.0, 10);
        ProductAfter after = new ProductAfter("P2", "Chair", 1000.0, 15);

        System.out.println("Before override: ");
        System.out.println(before);
        System.out.println("After override: ");
        System.out.println(after);
    }
}

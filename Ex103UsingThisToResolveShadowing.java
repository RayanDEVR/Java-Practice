/*
Using this to Resolve Shadowing   [Code Completion | Intermediate]
Complete a constructor whose parameters have the same names as fields.
Explain which name each side of this.field = field refers to.
Done when: All fields receive constructor values and the explanation is accurate.
*/

class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class Ex103UsingThisToResolveShadowing {
    public static void main(String[] args) {
        Product p = new Product("Pen", 10);
        System.out.println(p.name + ": " + p.price);
    }
}

/*
Explanation: on the left side of "=" , 'this.name' refers to the object's
field; on the right, plain 'name' refers to the constractor parameter.
 */
/*
Product Object Array   [Build from Scratch | Intermediate]
Create Product with id, name, price and stock. Populate Product[] and print a compact catalogue with an 
enhanced for loop.
Done when: Every array slot contains an object and fields are meaningful.
*/

class Product {
    private int id;
    private String name;
    private int price;
    private int stock;

    public Product(int id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void productCatalogue() {
        System.out.println("ID: " + id + " Name: " + name + " Price: " + price + " Stock: " + stock);
    }
}

public class Ex079ProductObjectArray {
    public static void main(String[] args) {
        Product[] catalogue = new Product[5];
        catalogue[0] = new Product(1001, "Computer", 1500, 50);
        catalogue[1] = new Product(1002, "Pendrive", 150, 70);
        catalogue[2] = new Product(1003, "Mouse", 500, 60);
        catalogue[3] = new Product(1004, "WebCAM", 1700, 20);
        catalogue[4] = new Product(1005, "Keyboard", 1000, 10);

        
        for (Product i : catalogue) {
            i.productCatalogue();
        }

        System.out.println("Total Products: " + catalogue.length);
    }
}

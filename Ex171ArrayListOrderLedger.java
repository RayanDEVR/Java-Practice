/*
ArrayList Order Ledger   [Build from Scratch | Advanced]
Store Order objects in List/ArrayList. Add, retrieve, update and remove by index where appropriate, then print all 
with enhanced for.
Done when: Insertion order and duplicates are understood; invalid index access is prevented.
*/

import java.util.ArrayList;
import java.util.List;

class Order {
    int id;
    double amount;

    Order(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String toString() {
        return "Order#" + id + " ($" + amount + ")";
    }
}

public class Ex171ArrayListOrderLedger {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(101, 1000));
        orders.add(new Order(102, 1500));
        orders.add(new Order(103, 2000));
        orders.add(new Order(104, 2500));

        int indoexToRemove = 2;
        if (indoexToRemove < orders.size()) {
            orders.remove(indoexToRemove);
        }
        else
            System.out.println("Invalid index.");

        orders.remove(0);

        for (Order o : orders) {
            System.out.println(o);
        }
    }
}

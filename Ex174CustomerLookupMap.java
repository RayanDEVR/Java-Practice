/*
Customer Lookup Map   [Scenario-Based | Advanced]
Use Map/HashMap from customer ID to Customer. Add records with put, retrieve by key, update a value, and 
iterate keys/values using operations shown in the lesson.
Done when: Key replacement behavior is demonstrated and missing IDs are handled safely.
*/

import java.util.HashMap;
import java.util.Map;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

public class Ex174CustomerLookupMap {
    public static void main(String[] args) {
        Map<Integer, Customer> customers = new HashMap<>();
        customers.put(101, new Customer("Rayan"));
        customers.put(102, new Customer("Samiul"));
        customers.put(103, new Customer("Radoan"));

        System.out.println("Lookup 102: " + customers.get(102));

        customers.put(102, new Customer("Abdullah"));
        System.out.println("After updated, 102: " + customers.get(102));

        for (int customer : customers.keySet()) {
            System.out.println("ID: " + customer + " - " + customers.get(customer));
        }
    }
}

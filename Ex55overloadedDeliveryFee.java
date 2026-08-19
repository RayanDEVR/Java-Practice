/*
Overloaded Delivery Fee   [Scenario-Based | Intermediate]
Design overloads for local distance-based delivery, fixed-zone delivery and member-aware delivery using 
different parameter lists. Explain why return-type-only overloading is illegal.
Done when: Each signature represents a genuinely different input contract and compiles without ambiguity.
*/

class delivery {
    public double distance(double distance, String zone, int member) {
        if((distance > 0 && distance < 10000) && (zone == "Dhaka") && (member > 0 && member <=5))
            return  50;
        else
            return 100;
    }
}

public class Ex55overloadedDeliveryFee {
    public static void main(String[] args) {
        delivery info = new delivery();
        double fee = info.distance(50000, "Dhaka", 3);
        System.out.println("Delivery Fee: " + fee);
    }
}

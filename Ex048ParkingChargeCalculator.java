/*
Parking Charge Calculator   [Scenario-Based | Beginner]
Calculate parking fee using first-hour, additional-hour and daily-cap rules. Use decisions and loops only where 
justified.
Done when: Tests include 0, 1, 2, 10 and 24 hours and respect the cap.
 */

public class Ex048ParkingChargeCalculator {
    public static void main(String[] args) {
        int hour = 10;
        int fee;

        if(hour <=1)
            fee = 50;
        else
            fee = 50 + ((hour - 1) * 20);

        if (fee > 300)
            fee = 300;

        System.out.println("Parking Fee: " + fee);
    }
}

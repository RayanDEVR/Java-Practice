/*
Controlled Array Update   [Bug Fixing | Intermediate]
Repair code that updates stock by a user-supplied index without validation. Add a condition that prevents an 
invalid access and prints a useful message.
Done when: Negative and length-sized indexes no longer crash the program. 
*/

public class Ex71controlledArrayUpdate {
    public static void main(String[] args) {
        int[] stocks = { 10, 20, 30, 40, 50 };

        int index = 4;
        int newStock = 60;
        
            if(newStock >= 0 && index < stocks.length)
                stocks[index] = newStock;
            else {
                System.out.println("Invalid Access");
                return;
            }

        for(int s: stocks)
            System.out.println(s);
    }
}

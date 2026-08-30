/*
Enhanced-for Suitability   [Refactoring | Intermediate]
Refactor read-only traversal to enhanced for. Keep index-based loops where the index is needed for update or 
reporting, and explain the difference.
Done when: The student uses enhanced for intentionally, not mechanically.
*/

public class Ex078EnhancedForSuitability {
    public static void main(String[] args) {
        double[] prices = { 100, 200, 300, 150 };

        double totalPrice = 0;                                     //total price
        for (double total : prices) {
            totalPrice += total;
        }
        System.out.println("Total Price: " + totalPrice);


        for (int i = 0; i < prices.length; i++) {                           //items' position
            System.out.println("Item#" + (i + 1) + ": " + prices[i]);
        }
        
        for (int i = 0; i < prices.length; i++) {                           //increasing price
            System.out.println("Price Increased; Item#" + (i+1) + ": " + (prices[i] + (prices[i] * 0.1)));
        }
    }
}


/*total, index, price increase */

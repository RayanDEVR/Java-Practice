/*
Apply a Price Increase   [Build from Scratch | Intermediate]
Given an array of prices, produce a second array containing each price after a percentage increase. Preserve the 
original array.
Done when: Both arrays are printed and the original remains unchanged.
*/

public class Ex73applyAPriceIncrease {
    public static void main(String[] args) {
        double[] prices = { 1000, 1500, 2000, 1200, 4500 };
        double increaseInPercent = 10;

        System.out.println("Original: ");
        for (double price : prices)
            System.out.println(price);
        
        System.out.println("Updated: ");
        for (double price : prices) System.out.println(price + (price * increaseInPercent) / 100);
    }
}

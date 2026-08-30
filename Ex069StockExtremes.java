/*
Stock Extremes   [Build from Scratch | Intermediate]
Find the smallest and largest stock quantity in a non-empty array and print their indexes. Start from the first 
element rather than arbitrary sentinel values. 
*/

public class Ex069StockExtremes {
    public static void main(String[] args) {
        int[] stock = { 20, 30, 50, 13, 60 };
        
        int maxStock = stock[0];
        int minStock = stock[0];
        int minIndex = 0; 
        int maxIndex = 0;

        for (int i = 0; i < stock.length; i++) {
            
            if (maxStock < stock[i]) {
                maxStock = stock[i];
                maxIndex= i;
            }
            if (minStock > stock[i]) {
                minStock = stock[i];
                minIndex = i;
            }

        }
        
        System.out.println("Min Stock: " + minStock + " at Index " + minIndex);
        System.out.println("Max Stock: " + maxStock + " at Index " + maxIndex);
    }
}

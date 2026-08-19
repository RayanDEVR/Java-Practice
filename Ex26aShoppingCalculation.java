/*
Complete a Shopping Calculation   [Code Completion | Beginner]
Fill missing operators and casts so a cart with itemCount, price and discountPercent prints a fractional discount 
and correct payable total.
Done when: The solution works for 0%, 15% and 100% discount without accidental integer division.
 */

public class Ex26aShoppingCalculation {
    public static void main(String[] args) {
         int itemCount = 10;
         int price = 1000;
         double discountPercent;
         int preDiscountTotal = itemCount * price;

         if(preDiscountTotal < 500 )
         {
             discountPercent = (double) 0 / 100;
             System.out.println((int) (preDiscountTotal - (preDiscountTotal * discountPercent)));
         }
         
         else if(preDiscountTotal >= 1000 && preDiscountTotal < 10000)
         {
             discountPercent = (double) 15 / 100;
             System.out.println((int) (preDiscountTotal - (preDiscountTotal * discountPercent)));
         }
         
         else if (preDiscountTotal >= 10000)
         {
             discountPercent = (double) 100 / 100;
            System.out.println((int) (preDiscountTotal - (preDiscountTotal * discountPercent)));
         }
    }
}


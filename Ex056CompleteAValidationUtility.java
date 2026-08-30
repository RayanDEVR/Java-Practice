/*
Complete a Validation Utility   [Code Completion | Intermediate]
Fill blanks in isValidQuantity, isValidPrice and canCheckout methods. The checkout method must combine the 
smaller validation methods.
Done when: All methods return booleans and boundary tests are included.
 */

class validationUtil {
    public boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    public boolean isValidPrice(double price) {
        return price > 0;
        }

    public boolean canCheckout(int quantity, double price) {
        return isValidQuantity(quantity) && isValidPrice(price);
    }
}

public class Ex56completeAValidationUtility {
    public static void main(String[] args) {

        validationUtil obj = new validationUtil();

        System.out.println(obj.isValidQuantity(12));
        System.out.println(obj.isValidPrice(0));
        System.out.println(obj.canCheckout(19, 23));
    }
}  

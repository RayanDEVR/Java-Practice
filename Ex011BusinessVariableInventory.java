/*
Business Variable Inventory   [Basic Coding | Beginner]
Declare values for an order ID, product quantity, unit price, tax rate, customer grade, paid flag and a very large 
transaction reference. Choose a primitive type for each and comment why.
Done when: The program compiles and each type choice matches the value’s range and meaning.
*/

public class Ex11BusinessVariableInventory {
    public static void main(String[] args) {
        long orderID = 113_7489201_8392041l;
        int quantity = 1500;
        double unitPrice = 15.5;
        float taxRate = 0.12f;
        char customerGrade = 'A';
        boolean paidFlag = true;
        long largeTransaction = 3726427836l;

        double total = quantity * unitPrice;
        double taxAmount = total * taxRate;

        System.out.println("Order ID: " + orderID);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + total);
        System.out.println("Tax amount: " + taxAmount);
        System.out.println("Customer grade: " + customerGrade);
        System.out.println("Transaction: " + largeTransaction);
        System.out.println("Paid: " + paidFlag);
    }
}

/*
int - support normal number
double - support point value
float - support point value (with f)
char - support single letter
blooean - support true and false
long - support large number (with l) */

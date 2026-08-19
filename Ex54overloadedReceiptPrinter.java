/*
Overloaded Receipt Printer   [Build from Scratch | Intermediate]
Overload printReceipt for: total only; customer name plus total; customer name, total and paid status. Each 
overload should produce a coherent receipt.
Done when: Calls resolve unambiguously and shared formatting is not needlessly copied.
 */

class receiptPrinter {
    public void printReceipt(double total) {
        System.out.println("Total: " + total);
    }
    
    public void printReceipt(String customerName, double total) {
        System.out.println("Customer Name: " + customerName + ", Total: " + total);
    }

    public void printReceipt(String customerName, double total, boolean paidStatus)
    {
        String status = paidStatus ? "Paid" : "Not Paid";
        System.out.println("Customer Name: " + customerName + ", Total: " + total + " Paid Status: " + status);
    }
}

public class Ex54overloadedReceiptPrinter {
    public static void main(String[] args) {
        receiptPrinter a = new receiptPrinter();

        a.printReceipt(1500);
        a.printReceipt("Rayan", 1500);
        a.printReceipt("Rayan", 1500, true);
    }
}

/*
Two Concurrent Activities   [Build from Scratch | Advanced]
Create two Thread subclasses representing receipt printing and inventory checking, each printing several steps. 
Run them repeatedly and record ordering differences.
Done when: The program demonstrates interleaving and does not assert one fixed order.
*/

class ReceiptPrinter extends Thread {
    @Override 
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Printing receipt line: " + i);
        }
    }
}

class InventoryChecker extends Thread {
    @Override 
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Checking inventory item: " + i);
        }
    }
}

public class Ex162TwoConcurrentActivities {
    public static void main(String[] args) throws InterruptedException {
        ReceiptPrinter receiptTask = new ReceiptPrinter();
        InventoryChecker inInventoryTask = new InventoryChecker();

        receiptTask.start();
        inInventoryTask.start();

        receiptTask.join();
        inInventoryTask.join();

    }
}

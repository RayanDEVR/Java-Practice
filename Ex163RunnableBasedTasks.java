/*
Runnable-Based Tasks   [Refactoring | Advanced]
Refactor the previous task so work implements Runnable and Thread objects execute it. Explain the design 
advantage when a class may need another superclass.
Done when: Both tasks run and business work is separated from thread objects.
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

public class Ex163RunnableBasedTasks {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReceiptPrinter());
        Thread t2 = new Thread(new InventoryChecker());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

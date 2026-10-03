/*
Thread-Safe Order Counter [Mini Project | Project]
Build a simplified order intake simulation where several Runnable workers create order IDs and reserve limited 
stock in shared services. First demonstrate the race, then synchronize the minimal critical operations.
Done when: No duplicate order ID or negative stock occurs in the safe version; workers are joined before the 
final report; design explains protected state.
*/


class OrderService {
    private int nextOrderId = 1;
    private int stock = 5;
    
    public void createOrder(String workerName) {
        if (stock <= 0) {
            System.out.println(workerName + " -> No stock.");
            return;
        }
        
        int orderId = nextOrderId;
        
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        nextOrderId++;
        stock--;
        
        System.out.println(workerName + " created Order #" + orderId + " | Stock: " + stock);
    }
    
    int getNextOrderId() {
        return nextOrderId;
    }
    
    int getStock() {
        return stock;
    }
}

class OrderWorker implements Runnable {
    private String name;
    private OrderService service;
    
    OrderWorker(String name, OrderService service) {
        this.name = name;
        this.service = service;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 3 ; i++) {
            service.createOrder(name);
        }
    }
}

public class Ex199A_UnsafeOrderCounter {
    public static void main(String[] args) {
        OrderService service = new OrderService();
        
        Thread t1 = new Thread(new OrderWorker("Worker-1", service));
        Thread t2 = new Thread(new OrderWorker("Worker-2", service));
        Thread t3 = new Thread(new OrderWorker("Worker-3", service));
        
        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println();
        System.out.println("Final stock: " + service.getStock());
        System.out.println("Next Order ID: " + service.getNextOrderId());
    }
}
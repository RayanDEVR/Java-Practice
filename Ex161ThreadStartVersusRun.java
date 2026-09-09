/*
Thread start Versus run   [Output Prediction | Advanced]
Create a Thread subclass that prints the current thread name or clear markers. Call run directly once and start 
once; compare behavior/order and explain.
Done when: The student identifies that start requests a new execution thread while direct run is an ordinary 
method call.
*/

class Worker extends Thread {
    String label;

    Worker(String label) {
        this.label = label;
    }

    @Override 
    public void run() {
        System.out.println(label + " running on thread " + Thread.currentThread().getName());
    }
}

public class Ex161ThreadStartVersusRun {
    public static void main(String[] args) {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        Worker w1 = new Worker("DirectRunCall");
        w1.run();

        Worker w2 = new Worker("StartCall");
        w2.start();
    }
}

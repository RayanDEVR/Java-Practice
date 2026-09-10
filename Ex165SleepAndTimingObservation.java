/*
Sleep and Timing Observation   [Code Reading | Advanced]
Add sleep between task steps and handle the required exception. Observe that sleep delays a thread but does 
not guarantee another thread’s exact schedule.
Done when: The explanation avoids using sleep as synchronization or proof of order.
*/

class DelayedTask extends Thread {
    String lebel;

    DelayedTask(String lebel) {
        this.lebel = lebel;
    }
    @Override 
    public void run(){
        
        for (int i = 1; i < 3; i++) {
            System.out.println(lebel + " - step " + i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Ex165SleepAndTimingObservation {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DelayedTask("Task1"));
        Thread t2 = new Thread(new DelayedTask("Task2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

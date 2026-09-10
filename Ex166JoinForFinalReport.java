/*
join for Final Report   [Bug Fixing | Advanced]
A main thread prints the final counter before worker threads finish. Use join so the final report occurs after both 
workers complete.
Done when: The final line always appears after worker completion and interruption is handled/declared 
appropriately.
*/

class Worker extends Thread {
    int counter = 0;
    @Override 
    public void run() {
        for (int i = 0; i < 1000; i++) 
            counter++;
    }
}

public class Ex166JoinForFinalReport {
    public static void main(String[] args) throws InterruptedException{
        Worker w1 = new Worker();
        Worker w2 = new Worker();

        w1.start();
        w2.start();

        w1.join();
        w2.join();

        System.out.println("Final counter(after join): " + (w1.counter + w2.counter));
    }
}

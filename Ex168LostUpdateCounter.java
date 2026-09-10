/*
Lost Update Counter   [Bug Fixing | Advanced]
Two threads increment a shared counter many times. First reproduce an incorrect final value, then protect the 
increment using synchronized behavior.
Done when: The synchronized version consistently reaches the expected total across repeated runs.
*/

class Counter {
    int count = 0;

    // void increment() {       Unsafe
    //     count++;
    // }

    synchronized void increment() {     //Safe
        count++;
    }
}

class IncrementTask extends Thread {
    Counter counter;

    IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override 
    public void run() {
        for (int i = 0; i < 10000; i++){
            counter.increment();
        }
    }
}

public class Ex168LostUpdateCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncrementTask t1 = new IncrementTask(counter);
        IncrementTask t2 = new IncrementTask(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.count);
    }
}

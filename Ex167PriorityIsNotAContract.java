/*
Priority Is Not a Contract   [Experiment | Advanced]
Assign different priorities to two threads, run the program many times and record output. Write a conclusion 
about why business correctness cannot depend on priority.
Done when: The conclusion reflects observed nondeterminism and the course’s warning level.
*/

class PriorityTask extends Thread {
    PriorityTask(String name) {
        super(name);
    }
    @Override 
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println(getName() + " - step " + i);
        }
    }
}

public class Ex167PriorityIsNotAContract {
    public static void main(String[] args) {
        PriorityTask highPriority = new PriorityTask("High");
        PriorityTask lowPriority = new PriorityTask("Low");

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
